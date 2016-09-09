package ru.kpfu.itis.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.kpfu.itis.model.VkAuthUser;
import ru.kpfu.itis.model.enums.AuthorityType;
import ru.kpfu.itis.repository.VkAuthUserRepository;
import ru.kpfu.itis.security.VkTokenAuthentication;
import ru.kpfu.itis.service.AuthenticationService;
import ru.kpfu.itis.service.VkUserService;
import ru.kpfu.itis.utils.Utils;

/**
 * Created by Юлия on 07.09.2016.
 */
@Controller
public class VkUserController {

    public final String CLIENT_ID = "5609595";
    public final String CLIENT_SECRET = "udqVuvIQ4o5lTREe1XpJ";
    public final String REDIRECT_URI = "http://85.143.211.252:8080/success";
    public final String ACCESS_TOKEN_URL = "https://oauth.vk.com/access_token";
    public final String API_URL = "https://api.vk.com/method/users.get";

    @Autowired
    VkAuthUserRepository vkRepository;

    @Autowired
    VkUserService vkService;

    @Autowired
    AuthenticationService authService;

    /*Vk signin*/
    @RequestMapping(value = "/login/vk")
    public ModelAndView vkRegistration() throws Exception {
        return new ModelAndView(new RedirectView("https://oauth.vk.com/authorize?client_id=" + CLIENT_ID + "&display=page&redirect_uri=" + REDIRECT_URI + "&response_type=code&v=5.53", true, true, true));
    }

    /*Redirect after confirming vk*/
    @RequestMapping(value = "/success")
    public String successPage(@RequestParam("code") String code, Model model) {
        String request = Utils.sendHttpGetRequest(ACCESS_TOKEN_URL, new String[]{"client_id", "client_secret", "redirect_uri", "code"}, new String[]{CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, code});
        JSONObject jsonReq = new JSONObject(request);
        String accessToken = jsonReq.getString("access_token");
        //Integer expiresIn = jsonReq.getInt("expires_in");

        String userInfo = Utils.sendHttpGetRequest(API_URL, new String[]{"fields", "access_token"}, new String[]{"photo_50", accessToken});
        JSONObject jsonRequest = new JSONObject(userInfo);
        JSONObject jsonUserInfo = (JSONObject) jsonRequest.getJSONArray("response").get(0);
        String uid = Integer.toString(jsonUserInfo.getInt("uid"));
        String photo = jsonUserInfo.getString("photo_50");

        VkAuthUser user = vkRepository.findOneByUsernameAndType(uid, AuthorityType.VK);

        if (user == null) { //saving in DB
            vkService.saveNewUser(accessToken, uid, jsonUserInfo.getString("first_name"), jsonUserInfo.getString("last_name"), photo);
            user = vkRepository.findOneByUsernameAndType(uid, AuthorityType.VK);
        } else {            //update info in DB
            vkService.updateUserInfo(user.getId(), accessToken, jsonUserInfo.getString("first_name"), jsonUserInfo.getString("last_name"), photo);
        }

        //authentication
        authService.login(new VkTokenAuthentication(user, SecurityContextHolder.getContext().getAuthentication().getDetails()));
        return "redirect:/";
    }
}

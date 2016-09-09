package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.service.SimpleUserService;

import javax.validation.Valid;

/**
 * Created by Юлия on 07.09.2016.
 */
@Controller
public class SimpleUserController {

    @Autowired
    SimpleUserService simpleUserService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    /*Simple user registration*/
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") @Valid UserRegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        simpleUserService.saveNewUser(form);
        return "redirect:/";
    }

    /*Simple user signin*/
    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }
}

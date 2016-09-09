package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.SimpleAuthUser;
import ru.kpfu.itis.model.VkAuthUser;
import ru.kpfu.itis.repository.SimpleAuthUserRepository;
import ru.kpfu.itis.repository.VkAuthUserRepository;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    SimpleAuthUserRepository simpleUserRepository;
    @Autowired
    VkAuthUserRepository vkUserRepository;

    @RequestMapping(value = "/")
    public String getIndexPage(Model model) {
        List<SimpleAuthUser> simpleUsers = simpleUserRepository.findAll();
        List<VkAuthUser> vkUsers = vkUserRepository.findAll();
        model.addAttribute("simpleUsers", simpleUsers);
        model.addAttribute("vkUsers", vkUsers);
        return "index";
    }
}

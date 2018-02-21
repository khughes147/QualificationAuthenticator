package com.example.QualificationAuthenticator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NavController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("university", new University());
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public String verify() {
        return "verify";
    }

    @RequestMapping(value = "/administration", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }


}

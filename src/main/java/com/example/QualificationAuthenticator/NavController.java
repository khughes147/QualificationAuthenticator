package com.example.QualificationAuthenticator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class NavController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("university", new University());
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("university", new University());
        return "index";
    }

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String about(Model model) {
        model.addAttribute("university", new University());
        return "about";
    }

    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public String verify(Model model) {
        model.addAttribute("university", new University());
        return "verify";
    }

    @RequestMapping(value = "/administration", method = RequestMethod.GET)
    public String admin(Model model) {
        model.addAttribute("university", new University());
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("university", new University());
        return "login";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publish(Model model) {
        model.addAttribute("university", new University());
        return "publish";
    }




}

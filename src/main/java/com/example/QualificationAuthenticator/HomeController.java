package com.example.QualificationAuthenticator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
}

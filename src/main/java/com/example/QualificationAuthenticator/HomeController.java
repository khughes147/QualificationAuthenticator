package com.example.QualificationAuthenticator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String about() {
        return "about.html";
    }

    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public String verify() {
        return "verify.html";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register() {
        return "register.html";
    }
}

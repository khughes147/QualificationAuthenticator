package com.example.QualificationAuthenticator;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegistrationController {

String userEmail;

    @RequestMapping(value = "/addnewuser")

    public String greetingSubmit() {
        return "result";
    }
    }



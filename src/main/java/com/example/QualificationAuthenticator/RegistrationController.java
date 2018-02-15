package com.example.QualificationAuthenticator;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegistrationController {


    @RequestMapping(value = "/emailSubmission", method = RequestMethod.POST)

    public String greetingSubmit( @RequestParam String anEmail ) {
        System.out.println(anEmail);
        return "index";
    }
    }


package com.example.QualificationAuthenticator;
import com.example.QualificationAuthenticator.University;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.lang.Object;


@Controller
public class RegistrationController {


    @PostMapping("/emailSubmission")
    public String emailSubmission(@ModelAttribute University university)
    {

        System.out.println(university.getEmail());
        return "index";
    }
}


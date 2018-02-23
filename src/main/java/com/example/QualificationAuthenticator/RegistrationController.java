package com.example.QualificationAuthenticator;
import com.example.QualificationAuthenticator.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    RegisterService regServ;

    @PostMapping("/emailSubmission")
    public String emailSubmission(@ModelAttribute University university, BindingResult result)
    {

        System.out.println(university.getUniName());
        System.out.println(university.getAdminName());
        System.out.println(university.getEmail());

        regServ.sendSimpleMessage(university.getEmail(), "Registration in Progress", "Hi " + university.getAdminName() + ",\n\nThis email is to confirm that we are checking your registration as an Admin for " + university.getUniName() +  " and we will get back to you as soon as possible.\n\nMany thanks,\n\nAuthenti-Q" );
        regServ.sendSimpleMessage("authentiq.register@gmail.com", "New registration", "Please investigate the following registration:\n \nAdministrator name: " + university.getAdminName() + "\nUniversity name: " + university.getUniName() + "\nAdmin email: " + university.getEmail() + "\n\nIf authentic, please login to admin system and add this university." );
        return "index";
    }
}


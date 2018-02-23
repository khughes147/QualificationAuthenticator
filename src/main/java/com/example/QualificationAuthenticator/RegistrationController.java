package com.example.QualificationAuthenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    @Autowired
    EmailService regServ;

    @PostMapping("/emailSubmission")
    public String emailSubmission(@ModelAttribute University university, BindingResult result)
    {

        regServ.sendSimpleMessage(university.getEmail(), "Registration in Progress", "Hi " + university.getAdminName() + ",\n\nThis email is to confirm that we are checking your registration as an Admin for " + university.getUniName() +  " and we will get back to you as soon as possible.\n\nMany thanks,\n\nAuthenti-Q" );
        regServ.sendSimpleMessage("authentiq.register@gmail.com", "New registration", "Please investigate the following registration:\n \nAdministrator name: " + university.getAdminName() + "\nUniversity name: " + university.getUniName() + "\nAdmin email: " + university.getEmail() + "\n\nIf authentic, please login to admin system and add this university." );
        return "index";
    }

    @PostMapping("/addUniversity")
    public String addUniversity(@ModelAttribute University university, BindingResult result)
    {
        System.out.println(university.getEmail());
        regServ.sendSimpleMessage(university.getEmail(), "Registration Success!!", "Hi " + university.getAdminName() + ",\n\nThis email is to confirm that " + university.getUniName() +  " has successfully been added to the Authenti-Q service.\n\nMany thanks,\n\nAuthenti-Q" );
        return "admin";
    }
}


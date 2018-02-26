package com.example.QualificationAuthenticator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class RegistrationController {

    private ArrayList<University> universityArrayList = new ArrayList<University>();

    @Autowired
    EmailService regServ;

    @PostMapping("/emailSubmission")
    public String emailSubmission(@ModelAttribute University university, BindingResult result)
    {

       // regServ.sendSimpleMessage(university.getEmail(), "Registration in Progress", "Hi " + university.getAdminName() + ",\n\nThis email is to confirm that we are checking your registration as an Admin for " + university.getUniName() +  " and we will get back to you as soon as possible.\n\nMany thanks,\n\nAuthenti-Q" );
       // regServ.sendSimpleMessage("authentiq.register@gmail.com", "New registration", "Please investigate the following registration:\n \nAdministrator name: " + university.getAdminName() + "\nUniversity name: " + university.getUniName() + "\nAdmin email: " + university.getEmail() + "\n\nIf authentic, please login to admin system and add this university." );
        return "index";
    }

    @PostMapping("/addUniversity")
    public String addUniversity(@ModelAttribute University university, BindingResult result)
    {
        university.generateKey();

        //regServ.sendSimpleMessage(university.getEmail(), "Registration Success!!", "Hi " + university.getAdminName() + ",\n\nThis email is to confirm that " + university.getUniName() +  " has successfully been added to the Authenti-Q service.\n\nMany thanks,\n\nAuthenti-Q" );
        universityArrayList.add(university);


        for(int i=0; i<universityArrayList.size(); i++){

            System.out.println(universityArrayList.get(i).getEmail() + " " + universityArrayList.get(i).getKey());

        }
        return "admin";
    }

    @GetMapping(value = "/listUniversities")
    public ResponseEntity<List<University>> listAllUsers() {
        List<University> unis = universityArrayList;
        if (unis.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<University>>(unis, HttpStatus.OK);


    }

    @PostMapping("/deleteUni")
    public String deleteUni(@RequestParam String id)
    {
        System.out.println(id);
        return "admin";
    }
}


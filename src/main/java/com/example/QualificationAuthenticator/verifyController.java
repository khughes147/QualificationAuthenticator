package com.example.QualificationAuthenticator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class verifyController {

    private String returnPage;

    @PostMapping("/verifySubmission")
    public String verify(@RequestParam String applicantKey, Model model)
    {
        System.out.println(applicantKey);
        model.addAttribute("university", new University());
        return "verify";

    }

}

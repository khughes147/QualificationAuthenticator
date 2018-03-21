package com.example.QualificationAuthenticator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.web3j.tuples.generated.Tuple7;

import java.util.ArrayList;

import static com.example.QualificationAuthenticator.recordController.contract;

@Controller
public class verifyController {

    private String returnPage;
    private Tuple7 retrievedData;

    @PostMapping("/verifySubmission")
    public String verify(@RequestParam String applicantKey, Model model)
    {
        System.out.println(applicantKey);
        try {
            retrievedData = contract.returnQualification().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("studentName", retrievedData.getValue1());
        model.addAttribute("studentID", retrievedData.getValue2());
        model.addAttribute("studentEmail", retrievedData.getValue3());
        model.addAttribute("courseName", retrievedData.getValue4());
        model.addAttribute("startDate", retrievedData.getValue5());
        model.addAttribute("endDate",  retrievedData.getValue6());
        model.addAttribute("classification",  retrievedData.getValue7());
        model.addAttribute("university", new University());
        return "verify";

    }

}

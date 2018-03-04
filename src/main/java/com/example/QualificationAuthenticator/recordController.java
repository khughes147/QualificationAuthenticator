package com.example.QualificationAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
public class recordController {

    @PostMapping("/publishForm")
    public String emailSubmission(@ModelAttribute StudentRecord record, BindingResult result, Model model)
    {
        RegistrationController regCon = new RegistrationController();
        ArrayList<University> universityArrayList = regCon.getUniversityArrayList();



        for(int i=0; i<universityArrayList.size(); i++){

            if (universityArrayList.get(i).getKey().equals(record.getUniversityKey())){

                System.out.println("Success");
            }else{
                System.out.println("Fail");

            }

        }



        model.addAttribute("record", new StudentRecord());
        model.addAttribute("university", new University());
        return "publish";
    }

}

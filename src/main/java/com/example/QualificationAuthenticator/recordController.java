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

    private String returnPage;

    @PostMapping("/publishForm")
    public String publish(@ModelAttribute StudentRecord record, BindingResult result, Model model)
    {
        RegistrationController regCon = new RegistrationController();
        ArrayList<University> universityArrayList = regCon.getUniversityArrayList();
        for(int i=0; i<universityArrayList.size(); i++){
            if (universityArrayList.get(i).getKey().equals(record.getUniversityKey())){
                model.addAttribute("successMessage", "Successfully uploaded record!");
            }else{
                model.addAttribute("errorMessage", "Invalid University Key!");
            }
        }
        model.addAttribute("record", new StudentRecord());
        model.addAttribute("university", new University());
        return "publish";
    }

}

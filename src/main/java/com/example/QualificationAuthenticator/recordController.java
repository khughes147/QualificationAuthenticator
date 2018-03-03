package com.example.QualificationAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
public class recordController {

    @PostMapping("/publishForm")
    public String emailSubmission(@ModelAttribute StudentRecord record, BindingResult result)
    {
        System.out.println(record.getClassification());
        return "index";
    }

}

package com.example.QualificationAuthenticator;
import com.example.QualificationAuthenticator.University;
import com.sun.xml.internal.stream.Entity;
import jdk.nashorn.internal.ir.RuntimeNode;
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


    @RequestMapping(value = "/emailSubmission", method = RequestMethod.GET)
    public String displayLogin(Model model) {
        model.addAttribute("university", new University());
        return "index";
    }

    @RequestMapping(value = "/emailSubmission", method = RequestMethod.POST)
    public String emailSubmission(@ModelAttribute("university") University uni, BindingResult result, Model model)
    {
        model.addAttribute("university", uni);
        System.out.println(uni.getEmail());
        return "index";
    }
}


package com.example.QualificationAuthenticator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.tx.Contract;


import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

import static com.example.QualificationAuthenticator.QualificationAuthenticatorApplication.web3j;


@Controller
public class RegistrationController {

    private static ArrayList<University> universityArrayList = new ArrayList<University>();
    private ArrayList<University> unverifiedUniversityArrayList = new ArrayList<University>();

    public ArrayList<University> getUniversityArrayList() {
        return universityArrayList;
    }
    private Credentials creds;

    @Autowired
    EmailService regServ;

    @PostMapping("/emailSubmission")
    public ResponseEntity emailSubmission(@ModelAttribute University university, BindingResult result, Model model)
    {

        for(int o=0; o<unverifiedUniversityArrayList.size(); o++){
            if(unverifiedUniversityArrayList.get(o).getEmail().equals(university.getEmail())){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

        }
        unverifiedUniversityArrayList.add(university);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                regServ.sendSimpleMessage(university.getEmail(), "Registration in Progress", "Hi " + university.getAdminName() + ",\n\nThis email is to confirm that we are checking your registration as an Admin for " + university.getUniName() +  " and we will get back to you as soon as possible.\n\nMany thanks,\n\nAuthenti-Q" );
                regServ.sendSimpleMessage("authentiq.register@gmail.com", "New registration", "Please investigate the following registration:\n \nAdministrator name: " + university.getAdminName() + "\nUniversity name: " + university.getUniName() + "\nAdmin email: " + university.getEmail() + "\n\nIf authentic, please login to admin system and add this university." );
            }
        });
        t.start();
        return new ResponseEntity(HttpStatus.OK);
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

    @GetMapping(value = "/listUnverifiedUniversities")
    public ResponseEntity<List<University>> listUnverifiedUni() {

        List<University> unis = new ArrayList<University>();

        for (int i =0; i<unverifiedUniversityArrayList.size(); i++){

            if(unverifiedUniversityArrayList.get(i).isVerified() == false){
                unis.add(unverifiedUniversityArrayList.get(i));
            }
        }

        if (unis.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<University>>(unis, HttpStatus.OK);


    }

    @RequestMapping(value = "/deleteUni", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String Submit(@RequestParam("id") String email) {

        for(int i=0; i<universityArrayList.size(); i++){

            if(universityArrayList.get(i).getEmail().equals(email)){
                universityArrayList.remove(i);
            }

        }
        return "admin";
    }

    @RequestMapping(value = "/verifyUni", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String addUni(@RequestParam("id") String email) {

        for(int i=0; i<unverifiedUniversityArrayList.size(); i++){

            if(unverifiedUniversityArrayList.get(i).getEmail().equals(email)){
                unverifiedUniversityArrayList.get(i).setVerified(true);
                unverifiedUniversityArrayList.get(i).generateKey();
                universityArrayList.add(unverifiedUniversityArrayList.get(i));
                try {
                    WalletUtils.generateFullNewWalletFile(universityArrayList.get(i).getKey(), new File("C:/Users/khugh/documents/EthereumProjectChain/data/keystore"));


                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                } catch (InvalidAlgorithmParameterException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                regServ.sendSimpleMessage(unverifiedUniversityArrayList.get(i).getEmail(), "Registration Success!!", "Hi " + unverifiedUniversityArrayList.get(i).getAdminName() + ",\n\nThis email is to confirm that " + unverifiedUniversityArrayList.get(i).getUniName() +  " has successfully been added to the Authenti-Q service.\n Your private key is: " + unverifiedUniversityArrayList.get(i).getPrivateKey() + ". Please keep this secure as you will need it to upload records. \n\nMany thanks,\n\nAuthenti-Q" );

                for(int y=0; i<universityArrayList.size(); i++){
                    universityArrayList.get(y).setPrivateKey("null");
                }

            }

        }
        return "admin";
    }

    @RequestMapping(value = "/rejectUni", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String rejectUni(@RequestParam("id") String email) {

        for(int i=0; i<unverifiedUniversityArrayList.size(); i++){

            String emailAddress = unverifiedUniversityArrayList.get(i).getEmail();
            String adminName = unverifiedUniversityArrayList.get(i).getAdminName();
            String uniName = unverifiedUniversityArrayList.get(i).getUniName();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    regServ.sendSimpleMessage(emailAddress, "Publishing privileges removed", "Hi " + adminName + ",\n\nThis email is to confirm that " + uniName +  " has been removed from the Authenti-Q service.\n\nMany thanks,\n\nAuthenti-Q" );

                }
            });

            if(unverifiedUniversityArrayList.get(i).getEmail().equals(email)){
                t.start();
                unverifiedUniversityArrayList.remove(i);
            }

        }
        return "admin";
    }

}


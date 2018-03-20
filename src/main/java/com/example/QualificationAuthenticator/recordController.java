package com.example.QualificationAuthenticator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;


import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

import static com.example.QualificationAuthenticator.QualificationAuthenticatorApplication.web3;
import static com.example.QualificationAuthenticator.University.bytesToHex;


@Controller
public class recordController {

    private String returnPage;
    private Credentials creds;
    private String walletName;

    @PostMapping("/publishForm")
    public String publish(@ModelAttribute StudentRecord record, BindingResult result, Model model)
    {
        RegistrationController regCon = new RegistrationController();
        String digest = "";
        try{
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(record.getUniversityKey().getBytes("UTF-8"));
            digest = bytesToHex(salt.digest());
        }catch(Exception noSuchAlgorithmException){
        }

        File folder = new File("C:/Users/Kieran/Documents/EthereumProjectChain/data/keystore/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                walletName = listOfFiles[i].getName();
            }
        }

        ArrayList<University> universityArrayList = regCon.getUniversityArrayList();
        for(int i=0; i<universityArrayList.size(); i++){
            if (universityArrayList.get(i).getKey().equals(digest)){
                try {
                    Credentials creds = WalletUtils.loadCredentials(universityArrayList.get(i).getKey(), "C:/Users/Kieran/Documents/EthereumProjectChain/data/keystore/" + walletName);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                }

                try {
                    Qualification contract = Qualification.deploy(web3, creds, Contract.GAS_PRICE, Contract.GAS_LIMIT).send();
                } catch (Exception e) {
                    e.printStackTrace();
                }


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

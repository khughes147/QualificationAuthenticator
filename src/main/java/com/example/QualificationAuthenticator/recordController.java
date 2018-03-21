package com.example.QualificationAuthenticator;
//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.Tuple;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;


import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;
import java.util.concurrent.ExecutionException;

//import static com.example.QualificationAuthenticator.QualificationAuthenticatorApplication.web3;
import static com.example.QualificationAuthenticator.University.bytesToHex;


@Controller
public class recordController {

    private String returnPage;
    private Credentials creds;
    private String walletName;
    public  static StudentCredentials contract;

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

        File folder = new File("C:/Users/Khugh/Documents/EthereumProjectChain/data/keystore/");
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
                     creds = WalletUtils.loadCredentials(universityArrayList.get(i).getKey(), "C:/Users/Khugh/Documents/EthereumProjectChain/data/keystore/" + walletName);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                }
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Web3j web3j = Web3j.build(new HttpService());

                        try {
                            contract = StudentCredentials.deploy(web3j, creds, Contract.GAS_PRICE, Contract.GAS_LIMIT, record.getStudentName(), record.getStudentID(), record.getStudentEmail(), record.getCourseName(), record.getStartDate(), record.getEndDate(), record.getClassification()).send();
                            try {
                                System.out.println(contract.returnQualification().send());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    System.out.println("thread couldnt finish");
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

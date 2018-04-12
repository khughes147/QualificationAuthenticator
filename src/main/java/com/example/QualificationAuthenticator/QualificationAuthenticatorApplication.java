package com.example.QualificationAuthenticator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;


import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;


@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ComponentScan


public class QualificationAuthenticatorApplication {


    public static Web3j web3j = Web3j.build(new HttpService());
    public static Credentials mainCreds;
    private static String walletName;

	public static void main(String[] args) {
		SpringApplication.run(QualificationAuthenticatorApplication.class, args);
        File dir = new File("C:/Users/khugh/documents/EthereumProjectChain/data/mainKeystore");
        dir.mkdir();
        try {
            WalletUtils.generateFullNewWalletFile("ethereum", new File("C:/Users/khugh/documents/EthereumProjectChain/data/mainKeystore"));
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

        File folder = new File("C:/Users/Khugh/Documents/EthereumProjectChain/data/mainKeystore");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                walletName = listOfFiles[i].getName();
            }
        }

        try {
            mainCreds = WalletUtils.loadCredentials("ethereum", "C:/Users/khugh/documents/EthereumProjectChain/data/mainKeystore/" + walletName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }


    }
}

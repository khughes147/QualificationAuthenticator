package com.example.QualificationAuthenticator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ComponentScan


public class QualificationAuthenticatorApplication {

	public static Web3j web3 = Web3j.build(new HttpService()); // defaults to http://localhost:8545/
	public static String clientType = null;
	static String walletName;

	public static void main(String[] args) {
		SpringApplication.run(QualificationAuthenticatorApplication.class, args);

		File folder = new File("C:/Users/Kieran/Documents/EthereumProjectChain/data/keystore/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				walletName = listOfFiles[i].getName();
			}
		}

		//try {
			//Web3ClientVersion client = web3.web3ClientVersion().sendAsync().get();
		//	clientType = client.getWeb3ClientVersion();
		//	org.web3j.crypto.Credentials creds = WalletUtils.loadCredentials("29b355756bd9cdc12fca663051f837fddbdf8ac424c4d98ea082ce7c0d075270", "C:/Users/Kieran/Documents/EthereumProjectChain/data/keystore/" + walletName);
		//	com.example.QualificationAuthenticator.Credentials contract = com.example.QualificationAuthenticator.Credentials.deploy(web3, creds, Contract.GAS_PRICE, Contract.GAS_LIMIT, "keiran", "myEmail", "uuj", "compSci", "date", "date2   ", "1st").send();
		//	System.out.println(contract.returnQualification().send());
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//} catch (ExecutionException e) {
		//	e.printStackTrace();
		//} catch (IOException e) {
		//	e.printStackTrace();
	//	} catch (CipherException e) {
	//		e.printStackTrace();
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
		//System.out.println("\n" +  "Application has discovered and connected to Ethereum client: " + clientType);

	}
}

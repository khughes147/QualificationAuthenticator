package com.example.QualificationAuthenticator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;


import java.io.IOException;
import java.util.concurrent.ExecutionException;


@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ComponentScan


public class QualificationAuthenticatorApplication {

	public static Web3j web3 = Web3j.build(new HttpService()); // defaults to http://localhost:8545/
	public static String clientType = null;


	public static void main(String[] args) {
		SpringApplication.run(QualificationAuthenticatorApplication.class, args);
		try {
			Web3ClientVersion client = web3.web3ClientVersion().sendAsync().get();
			clientType = client.getWeb3ClientVersion();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("\n" +  "Application has discovered and connected to Ethereum client: " + clientType);

	}
}

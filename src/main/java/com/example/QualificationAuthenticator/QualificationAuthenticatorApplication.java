package com.example.QualificationAuthenticator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ComponentScan

public class QualificationAuthenticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualificationAuthenticatorApplication.class, args);
	}
}

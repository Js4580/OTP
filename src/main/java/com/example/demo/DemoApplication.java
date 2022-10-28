package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public JavaMailSenderImpl getJavaMailSenderImpl(){
		return new JavaMailSenderImpl();
	}

	@Bean
	public SimpleMailMessage getSimpleMailSender(){
		return new SimpleMailMessage();
	}

}

package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfiguration {
    private final JavaMailSenderImpl javaMailSender;

    @Autowired
    public EmailConfiguration(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.host}")
    private String mailServiceHost;
    @Value("${spring.mail.port}")
    private Integer mailServicePort;
    @Value("${spring.mail.username}")
    private String mailServiceUsername;
    @Value("${spring.mail.password}")
    private String mailServicePassword;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String mailServiceAuth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String mailServiceStarttls;
    


    @Bean
    public JavaMailSender getJavaMailSender(){
        javaMailSender.setHost(mailServiceHost);
        javaMailSender.setPort(mailServicePort);

        javaMailSender.setUsername(mailServiceUsername);
        javaMailSender.setPassword(mailServicePassword);

        Properties properties = javaMailSender.getJavaMailProperties();

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", mailServiceAuth);
        properties.put("mail.smtp.starttls.enable", mailServiceStarttls);
        properties.put("mail.debug", "true");

        return javaMailSender;
    }
}

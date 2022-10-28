package com.example.demo.services.impl;

import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    private final SimpleMailMessage simpleMailMessage;

    @Value("${spring.mail.username}")
    private String mailServiceUsername;

    @Autowired
    public EmailServiceImpl(
            @Qualifier("getJavaMailSender") JavaMailSender javaMailSender,
            SimpleMailMessage simpleMailMessage) {
        this.javaMailSender = javaMailSender;
        this.simpleMailMessage = simpleMailMessage;
    }

    @Override
    public void sendSimpleMessage(String to,
                                  String subject,
                                  String text) {

        try {
            int code = randomizeInt();
            String messageCode = "\nВаш код подтверждения - ";
            String lastMessage = " , не передавайте третьим лицам";

            simpleMailMessage.setFrom(mailServiceUsername);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(text + messageCode + code + lastMessage);

            javaMailSender.send(simpleMailMessage);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    private int randomizeInt() {
        Random random = new Random();
        int max = 8999;
        int min = 1000;
        int result = (int) (random.nextDouble() * max + random.nextDouble() + min);
        System.out.println(result);
        return result;
    }
}

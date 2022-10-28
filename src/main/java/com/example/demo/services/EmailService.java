package com.example.demo.services;

public interface EmailService {
    void sendSimpleMessage(
            String to,
            String subject,
            String text);
}

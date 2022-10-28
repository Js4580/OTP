package com.example.demo.utils;

public class MailBadSendException extends RuntimeException{
    public MailBadSendException(String message) {
        super(message);
    }
}

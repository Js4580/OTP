package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MailExceptionResponse {
    private String message;
    private Date timestamp;
}

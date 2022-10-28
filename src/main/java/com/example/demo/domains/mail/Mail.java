package com.example.demo.domains.mail;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mail {
    @NotNull
    @Email
    String to;
    String recipientName;
    @NotNull
    @Size(min = 3, max = 50)
    String subject;
    @NotNull
    @Size(min = 3, max = 50)
    String text;
    String senderName;
    String templateEngine;
}

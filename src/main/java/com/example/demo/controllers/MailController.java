package com.example.demo.controllers;

import com.example.demo.domains.mail.Mail;
import com.example.demo.services.EmailService;
import com.example.demo.utils.ErrorField;
import com.example.demo.utils.MailBadSendException;
import com.example.demo.utils.MailExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/mail")
public class MailController {
    private final EmailService emailService;

    @Autowired
    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<HttpStatus> sendMessagePerson(
            @RequestBody @Valid Mail mail,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            ErrorField.getErrorField(bindingResult);
        emailService.sendSimpleMessage(
                mail.getTo(),
                mail.getSubject(),
                mail.getText()
        );
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @ExceptionHandler
    private ResponseEntity<MailExceptionResponse> handleException(
            MailBadSendException mailBadSendException
    ) {
        MailExceptionResponse mail = new MailExceptionResponse(
                mailBadSendException.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(mail, HttpStatus.BAD_REQUEST);
    }
}

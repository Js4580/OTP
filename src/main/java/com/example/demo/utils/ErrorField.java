package com.example.demo.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorField {

    public static void getErrorField(BindingResult bindingResult) {
        StringBuilder stringError = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error :
                errors) {
            stringError
                    .append("поле: ")
                    .append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }
        throw new MailBadSendException(stringError.toString());
    }
}

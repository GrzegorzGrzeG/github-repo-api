package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = NoSuchFormatException.class)
    public ResponseEntity<Object> formatEx(NoSuchFormatException noSuchFormatException){
        return new ResponseEntity<>(noSuchFormatException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}

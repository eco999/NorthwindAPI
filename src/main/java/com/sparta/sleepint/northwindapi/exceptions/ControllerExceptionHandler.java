package com.sparta.sleepint.northwindapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<String> handleException(ResourceException e) {

        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
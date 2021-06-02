package com.example.house.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgException(IllegalArgumentException ex,
                                                            WebRequest wr) {
        String body = "Not found ";
        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
    }
}

package com.rest.springrestapi.controller;

import com.rest.springrestapi.services.ResourcesNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourcesNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest req){
        return new ResponseEntity<Object>("Kaynak Bulunamadi",new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}

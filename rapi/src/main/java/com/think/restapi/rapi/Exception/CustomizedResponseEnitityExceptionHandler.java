package com.think.restapi.rapi.Exception;

import java.net.http.HttpClient;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEnitityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails ed = new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails ed = new ErrorDetails(LocalDate.now(),"User Does not exist",request.getDescription(false));

        return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
    }
}

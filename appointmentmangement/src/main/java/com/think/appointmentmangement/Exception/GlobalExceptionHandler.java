package com.think.appointmentmangement.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlePatientNotFoundException(PatientNotFoundException px){
        Map<String,String> res = new HashMap<>();
        res.put("error", px.getMessage());
        res.put("status", "404");
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    } 

    @ExceptionHandler(DateException.class)
    public ResponseEntity<Map<String,String>> handleDateException(DateException dx){
        Map<String,String> res = new HashMap<>();
        res.put("error", dx.getMessage());
        res.put("status", "404");
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    } 

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValiadtionException(MethodArgumentNotValidException mx){
        Map<String,String> res = new HashMap<>();
        mx.getBindingResult().getFieldErrors().forEach(error -> {
            res.put(error.getField(), error.getDefaultMessage() );
        });
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    } 
    
}

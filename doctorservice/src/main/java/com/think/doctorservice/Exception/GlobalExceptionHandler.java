package com.think.doctorservice.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleDoctorNotFoundException(DoctorNotFoundException dx){
        Map<String,String> map = new HashMap<>();
        map.put("error", dx.getMessage());
        map.put("code", "404");

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
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

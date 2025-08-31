package com.think.restapi.rapi.Exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String messege){
        super(messege);
    }
}

package com.example.demo.exceptions;

public class WrongUsernameOrPasswordException extends RuntimeException{
    public WrongUsernameOrPasswordException(String ErrorMessage){
        super(ErrorMessage);
    }
}

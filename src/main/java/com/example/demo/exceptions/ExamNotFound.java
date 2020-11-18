package com.example.demo.exceptions;

public class ExamNotFound  extends RuntimeException{
    public ExamNotFound(Long id){
        super("Could not found exam: "+id);
    }
}

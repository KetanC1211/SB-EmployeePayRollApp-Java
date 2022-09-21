package com.bridgelabz.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class EmployeeCustomException extends RuntimeException{
    public EmployeeCustomException (String message){
        super(message);
    }
}

package com.workintech.zoo.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class Exception extends RuntimeException{
    private HttpStatus status;

    public Exception (String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}

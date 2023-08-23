package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class Validation {

    public static void isIdValid(int id){
        if(id<=0){
            throw new Exception("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdNotExist(Map animals, int id){
        if(!animals.containsKey(id)){
            throw new Exception("Id doesn't exist: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public static void isIdExist(Map animals, int id){
        if(animals.containsKey(id)){
            throw new Exception("Id already exist: " + id, HttpStatus.BAD_REQUEST);
        }
    }


}

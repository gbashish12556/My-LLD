package org.example.exceptions;

import lombok.AllArgsConstructor;


public class CacheException  extends Exception{

    private ExceptionType exceptionType;
    private String message;

    public CacheException(ExceptionType exceptionType, String message){
        super(message);
        this.exceptionType = exceptionType;
    }


}

package org.example.exceptions;

public class RestaurantException extends Exception{

    private ExceptionType exceptionType;
    private String messages;

    public RestaurantException(ExceptionType exceptionType, String messages){
        super(messages);
        this.exceptionType = exceptionType;
    }
}

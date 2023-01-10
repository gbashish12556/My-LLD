package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieException extends Exception{
    private ExceptionType exceptionType;
    private String exceptionMessage;


}

package org.example.utils.exceptions;

public class InvalidCurrencyCodeException extends Exception{
    public InvalidCurrencyCodeException(String msg){
        super(msg);
    }
}

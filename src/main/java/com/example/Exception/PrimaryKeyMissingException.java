package com.example.Exception;

public class PrimaryKeyMissingException extends RuntimeException {
    public PrimaryKeyMissingException(String message){
        super(message);
    }
}

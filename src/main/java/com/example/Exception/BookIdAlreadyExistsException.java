package com.example.Exception;

import io.micronaut.http.HttpStatus;

public class BookIdAlreadyExistsException extends RuntimeException{
    private final String reason;
    public BookIdAlreadyExistsException(String reason){
        super(reason);
        this.reason = reason;

    }
    public String getReason() {
        return reason;
    }

}

package com.example.springdataintro.exception;

public class EntityDoestNotExistException extends RuntimeException{

    public EntityDoestNotExistException(String message) {
        super(message);
    }
}

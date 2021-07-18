package com.softuni.springintroex.exception;

public class EntityDoestNotExistException extends RuntimeException{

    public EntityDoestNotExistException(String message) {
        super(message);
    }
}

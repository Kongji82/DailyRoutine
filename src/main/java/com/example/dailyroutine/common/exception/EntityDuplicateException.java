package com.example.dailyroutine.common.exception;

public class EntityDuplicateException extends RuntimeException{
    private final String message;

    public EntityDuplicateException(String message) {
        this.message = message;
    }
}

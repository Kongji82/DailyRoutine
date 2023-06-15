package com.example.dailyroutine.common.exception;

import lombok.Getter;

@Getter
public class EntityDuplicateException extends RuntimeException{
    private final String message;

    public EntityDuplicateException(String message) {
        this.message = message;
    }
}

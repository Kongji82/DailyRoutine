package com.example.dailyroutine.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EntityNotFoundException extends RuntimeException{
    private final String message;
}

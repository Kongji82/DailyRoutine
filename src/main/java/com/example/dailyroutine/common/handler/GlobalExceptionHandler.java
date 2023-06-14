package com.example.dailyroutine.common.handler;

import com.example.dailyroutine.common.exception.ApiExceptionResponse;
import com.example.dailyroutine.common.exception.EntityDuplicateException;
import com.example.dailyroutine.common.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiExceptionResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(404).body(ApiExceptionResponse.builder()
                .message(e.getMessage())
                .build());
    }
    @ExceptionHandler(EntityDuplicateException.class)
    public ResponseEntity<ApiExceptionResponse> handleEntityDuplicateException(EntityDuplicateException e) {
        return ResponseEntity.status(409).body(ApiExceptionResponse.builder()
                .message(e.getMessage())
                .build());
    }
}

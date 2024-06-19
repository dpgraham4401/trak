package com.haztrak.trak.rcrasite;

import com.haztrak.trak.rcrasite.errors.RcraSiteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class RcraSiteExceptionHandler {
    @ExceptionHandler(RcraSiteNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(RcraSiteNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    public record ExceptionResponse(String message, Integer code) {

    }
}

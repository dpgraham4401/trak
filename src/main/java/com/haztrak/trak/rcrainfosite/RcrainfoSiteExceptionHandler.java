package com.haztrak.trak.rcrainfosite;

import com.haztrak.trak.rcrainfosite.errors.RcrainfoSiteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class RcrainfoSiteExceptionHandler {
    @ExceptionHandler(RcrainfoSiteNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(RcrainfoSiteNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    public record ExceptionResponse(String message, Integer code) {

    }
}

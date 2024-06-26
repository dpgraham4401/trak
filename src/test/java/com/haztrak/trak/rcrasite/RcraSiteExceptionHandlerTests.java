package com.haztrak.trak.rcrasite;

import com.haztrak.trak.rcrasite.errors.RcraSiteNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Rcrainfo Site Exception Handler")
public class RcraSiteExceptionHandlerTests {

    @Test
    @DisplayName("Returns 404 status code and message when RcraSiteNotFoundException raised")
    public void handleRcraSiteNotFoundException() {
        String badEpaId = "BADID123";
        RcraSiteNotFoundException exception = new RcraSiteNotFoundException(badEpaId);
        RcraSiteExceptionHandler handler = new RcraSiteExceptionHandler();

        ResponseEntity<RcraSiteExceptionHandler.ExceptionResponse> response = handler.handleException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("RcrainfoSite not found " + badEpaId, response.getBody().message());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().code());
    }
}
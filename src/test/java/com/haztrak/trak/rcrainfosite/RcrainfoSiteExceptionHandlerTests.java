package com.haztrak.trak.rcrainfosite;

import com.haztrak.trak.rcrainfosite.errors.RcrainfoSiteNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Rcrainfo Site Exception Handler")
public class RcrainfoSiteExceptionHandlerTests {

    @Test
    @DisplayName("Returns 404 status code and message when RcrainfoSiteNotFoundException raised")
    public void handleRcrainfoSiteNotFoundException() {
        String badEpaId = "BADID123";
        RcrainfoSiteNotFoundException exception = new RcrainfoSiteNotFoundException(badEpaId);
        RcrainfoSiteExceptionHandler handler = new RcrainfoSiteExceptionHandler();

        ResponseEntity<RcrainfoSiteExceptionHandler.ExceptionResponse> response = handler.handleException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("RcrainfoSite not found " + badEpaId, response.getBody().message());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().code());
    }
}
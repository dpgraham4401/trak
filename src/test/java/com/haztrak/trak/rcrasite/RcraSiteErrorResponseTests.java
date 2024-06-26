package com.haztrak.trak.rcrasite;

import com.haztrak.trak.rcrasite.errors.RcraSiteErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RcraSiteErrorResponseTests {

    private RcraSiteErrorResponse response;

    @BeforeEach
    public void setup() {
        response = new RcraSiteErrorResponse(404, "Not Found", System.currentTimeMillis());
    }

    @Test
    public void statusIsSetCorrectly() {
        assertEquals(404, response.getStatus());
    }

    @Test
    public void messageIsSetCorrectly() {
        assertEquals("Not Found", response.getMessage());
    }

    @Test
    public void timestampIsSetCorrectly() {
        long timestamp = System.currentTimeMillis();
        response.setTimestamp(timestamp);
        assertEquals(timestamp, response.getTimestamp());
    }

    @Test
    public void changingStatusUpdatesStatus() {
        response.setStatus(200);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void changingMessageUpdatesMessage() {
        response.setMessage("OK");
        assertEquals("OK", response.getMessage());
    }

    @Test
    public void changingTimestampUpdatesTimestamp() {
        long newTimestamp = System.currentTimeMillis();
        response.setTimestamp(newTimestamp);
        assertEquals(newTimestamp, response.getTimestamp());
    }
}
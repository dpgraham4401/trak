package com.haztrak.trak.rcrasite.errors;

public class RcraSiteNotFoundException extends RuntimeException {
    public RcraSiteNotFoundException(String id) {
        super("RcrainfoSite not found " + id);
    }
}

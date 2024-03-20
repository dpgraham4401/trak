package com.haztrak.trak.rcrainfosite.errors;

public class RcrainfoSiteNotFoundException extends RuntimeException {
    public RcrainfoSiteNotFoundException(String id) {
        super("RcrainfoSite not found " + id);
    }
}

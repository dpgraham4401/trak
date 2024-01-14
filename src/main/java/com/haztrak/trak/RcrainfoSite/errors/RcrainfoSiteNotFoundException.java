package com.haztrak.trak.RcrainfoSite.errors;

public class RcrainfoSiteNotFoundException extends RuntimeException {
    public RcrainfoSiteNotFoundException(String id) {
        super("Could not find RcrainfoSite " + id);
    }
}

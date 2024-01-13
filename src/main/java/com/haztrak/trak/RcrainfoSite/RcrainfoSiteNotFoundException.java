package com.haztrak.trak.RcrainfoSite;

public class RcrainfoSiteNotFoundException extends RuntimeException {
    RcrainfoSiteNotFoundException(int id) {
        super("Could not find RcrainfoSite" + id);
    }
}

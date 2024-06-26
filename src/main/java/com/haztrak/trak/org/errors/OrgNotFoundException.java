package com.haztrak.trak.org.errors;


public class OrgNotFoundException extends RuntimeException {
    public OrgNotFoundException(int id) {
        super("Org not found " + id);
    }
}

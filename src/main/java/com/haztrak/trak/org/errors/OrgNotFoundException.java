package com.haztrak.trak.org.errors;


public class OrgNotFoundException extends RuntimeException {
    public OrgNotFoundException(int id) {
        super("Org not found " + id);
    }
}
//public class RcrainfoSiteNotFoundException extends RuntimeException {
//    public RcrainfoSiteNotFoundException(String id) {
//        super("RcrainfoSite not found " + id);
//    }
//}

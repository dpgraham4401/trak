package com.haztrak.trak.site;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SiteTests {

    @Test
    @DisplayName("site ID getter")
    public void idIsSetCorrectly() {
        String id = "site_id_1";
        Site mySite = new Site(id, "Test Org");
        assertEquals(id, mySite.getId());
    }

    @Test
    @DisplayName("name getter")
    public void nameIsSetCorrectly() {
        String name = "Test";
        Site mySite = new Site("id", name);
        assertEquals(name, mySite.getName());
    }

}
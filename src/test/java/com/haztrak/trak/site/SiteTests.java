package com.haztrak.trak.site;

import com.haztrak.trak.org.Org;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SiteTests {
    private Org org;

    @BeforeEach
    public void setUp() {
        org = mock(Org.class);
    }

    @Test
    @DisplayName("site ID getter")
    public void idIsSetCorrectly() {
        String id = "site_id_1";
        Site mySite = new Site(id, "Test name", org);
        assertEquals(id, mySite.getId());
    }

    @Test
    @DisplayName("name getter")
    public void nameIsSetCorrectly() {
        String name = "Test";
        Site mySite = new Site("id", name, org);
        assertEquals(name, mySite.getName());
    }

    @Test
    @DisplayName("Org getter")
    public void OrgGetterReturnsOrgInstance() {
        String name = "Test";
        Site mySite = new Site("id", name, org);
        assertEquals(name, mySite.getName());
    }

}
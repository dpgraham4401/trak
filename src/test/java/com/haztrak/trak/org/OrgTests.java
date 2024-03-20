package com.haztrak.trak.org;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrgTests {

    @Test
    @DisplayName("get organization ID")
    public void idIsSetCorrectly() {
        int id = 1;
        Org org = new Org(id, "Test Org");
        assertEquals(id, org.getId());
    }

    @Test
    @DisplayName("get Organization name")
    public void nameIsSetCorrectly() {
        String name = "Test Org";
        Org org = new Org(1, name);
        assertEquals(name, org.getName());
    }

    @Test
    @DisplayName("updates the organization ID")
    public void testSetOrgId() {
        int id = 1;
        int newId = 2;
        Org org = new Org(id, "Test Org");
        org.setId(newId);
        assertEquals(newId, org.getId());
    }

    @Test
    @DisplayName("set the organization name")
    public void testSetOrgName() {
        String originalName = "foo";
        String newName = "bar";
        Org org = new Org(1, originalName);
        org.setName(newName);
        assertEquals(newName, org.getName());
    }

}
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

    @Test
    @DisplayName("get Organization description")
    public void descriptionIsSetCorrectly() {
        String description = "Test Description";
        Org org = new Org(1, "Test Org");
        org.setDescription(description);
        assertEquals(description, org.getDescription());
    }

    @Test
    @DisplayName("set the organization description")
    public void testSetOrgDescription() {
        String originalDescription = "foo";
        String newDescription = "bar";
        Org org = new Org(1, "Test Org");
        org.setDescription(originalDescription);
        org.setDescription(newDescription);
        assertEquals(newDescription, org.getDescription());
    }

    @Test
    @DisplayName("get Organization subOrg")
    public void subOrgIsSetCorrectly() {
        Org org = new Org(1, "Test Org");
        Org anotherOrg = new Org(2, "foo");
        anotherOrg.setParentOrg(org);
        assertEquals(org, anotherOrg.getParentOrg());
    }

}
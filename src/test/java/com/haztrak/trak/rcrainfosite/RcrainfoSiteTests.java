package com.haztrak.trak.rcrainfosite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

@DisplayName("Rcrainfo Site")
public class RcrainfoSiteTests {

    @Test
    @DisplayName("EPA ID getter and setter")
    public void testEpaId() {
        String epaId = "12345";
        RcrainfoSite site = new RcrainfoSite();
        site.setEpaId(epaId);
        assertEquals(epaId, site.getEpaId());
    }

    @Test
    @DisplayName("Site Address getter and setter")
    public void testSiteAddress() {
        Address mockAddress = mock(Address.class);
        RcrainfoSite site = new RcrainfoSite();
        site.setSiteAddress(mockAddress);
        assertEquals(mockAddress, site.getSiteAddress());
    }

    @Test
    @DisplayName("Mailing Address getter and setter")
    public void testMailingAddress() {
        Address mockAddress = mock(Address.class);
        RcrainfoSite site = new RcrainfoSite();
        site.setMailingAddress(mockAddress);
        assertEquals(mockAddress, site.getMailingAddress());
    }

    @Test
    @DisplayName("EPA ID getter")
    public void testSiteEpaID() throws NoSuchFieldException, IllegalAccessException {
        RcrainfoSite site = new RcrainfoSite();
        String mockEpaId = "VATEST12345";
        site.setEpaId(mockEpaId);
        final Field field = site.getClass().getDeclaredField("epaId");
        field.setAccessible(true);
        assertEquals(field.get(site), mockEpaId);
    }

    @Test
    @DisplayName("Should set and get site type")
    public void siteType() {
        SiteType siteType = SiteType.Generator;
        RcrainfoSite site = new RcrainfoSite();
        site.setType(siteType);
        assertEquals(siteType, site.getType());
    }

    @Test
    @DisplayName("Should set and get GIS primary")
    public void gisPrimary() {
        Boolean gisPrimary = true;
        RcrainfoSite site = new RcrainfoSite();
        site.setGisPrimary(gisPrimary);
        assertEquals(gisPrimary, site.getGisPrimary());
    }

    @Test
    @DisplayName("Should set and get site name")
    public void siteName() {
        String name = "Test Site";
        RcrainfoSite site = new RcrainfoSite();
        site.setName(name);
        assertEquals(name, site.getName());
    }

    @Test
    @DisplayName("Should set and get site id")
    public void siteId() {
        int id = 1;
        RcrainfoSite site = new RcrainfoSite();
        site.setId(id);
        assertEquals(id, site.getId());
    }

    @Test
    @DisplayName("Should initialize with null site address")
    public void nullSiteAddressOnInit() {
        RcrainfoSite site = new RcrainfoSite();
        assertNull(site.getSiteAddress());
    }

    @Test
    @DisplayName("Should initialize with null mailing address")
    public void nullMailingAddressOnInit() {
        RcrainfoSite site = new RcrainfoSite();
        assertNull(site.getMailingAddress());
    }
}

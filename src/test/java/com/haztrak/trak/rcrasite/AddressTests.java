package com.haztrak.trak.rcrasite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Address")
public class AddressTests {

    @Test
    @DisplayName("Country getter and setter")
    public void testAddress() {
        String country = "USA";
        Address address = new Address();
        address.setCountry(country);
        assertEquals(country, address.getCountry());
    }

    @Test
    @DisplayName("Zip getter and setter")
    public void testZipGetterSetter() {
        String zip = "12345";
        Address address = new Address();
        address.setZip(zip);
        assertEquals(zip, address.getZip());
    }

    @Test
    @DisplayName("street number getter and setter")
    public void testStreetGetterSetter() {
        String streetNumber = "123";
        Address address = new Address();
        address.setStreetNumber(streetNumber);
        assertEquals(streetNumber, address.getStreetNumber());
    }

    @Test
    @DisplayName("Address1 getter and setter")
    public void testAddress1GetterSetter() {
        String address1 = "main street";
        Address address = new Address();
        address.setAddress1(address1);
        assertEquals(address1, address.getAddress1());
    }

    @Test
    @DisplayName("Address2 getter and setter")
    public void testAddress2GetterSetter() {
        String address2 = "apt. 313N";
        Address address = new Address();
        address.setAddress2(address2);
        assertEquals(address2, address.getAddress2());
    }

    @Test
    @DisplayName("city getter and setter")
    public void testCityGetterSetter() {
        String city = "New York";
        Address address = new Address();
        address.setCity(city);
        assertEquals(city, address.getCity());
    }

    @Test
    @DisplayName("state getter and setter")
    public void testStateGetterSetter() {
        String state = "Texas";
        Address address = new Address();
        address.setState(state);
        assertEquals(state, address.getState());
    }
}

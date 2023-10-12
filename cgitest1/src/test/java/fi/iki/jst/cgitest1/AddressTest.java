package fi.iki.jst.cgitest1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fi.iki.jst.cgitest1.model.Address;

public class AddressTest {

    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("Mannerheimintie 100", "00100", "Helsinki", "Finland");
    }

    @Test
    public void testGetAndSetStreetAddress() {
        assertEquals("Mannerheimintie 100", address.getStreetAddress());
        address.setStreetAddress("Leppävaarankatu 7");
        assertEquals("Leppävaarankatu 7", address.getStreetAddress());
    }

    @Test
    public void testGetAndSetZipCode() {
        assertEquals("00100", address.getZipCode());
        address.setZipCode("02600");
        assertEquals("02600", address.getZipCode());
    }

    @Test
    public void testGetAndSetPostalDistrict() {
        assertEquals("Helsinki", address.getPostalDistrict());
        address.setPostalDistrict("Espoo");
        assertEquals("Espoo", address.getPostalDistrict());
    }   

    @Test
    public void testGetAndSetCountry() {
        assertEquals("Finland", address.getCountry());
        address.setCountry("Sweden");
        assertEquals("Sweden", address.getCountry());
    }

    @Test
    public void testCopy() {
        Address copiedAddress = address.copy();
        assertEquals(address, copiedAddress); // Check if the copied address is equal to the original
        assertNotSame(address, copiedAddress); // Check if the copied address is not the same object as the original
    }

    @Test
    public void testEquals() {
        // Test equality for different instances of the same address
        assertEquals(address, new Address("Mannerheimintie 100", "00100", "Helsinki", "Finland"));

        // Test equality for different addresses
        assertNotEquals(address, new Address("Leppävaarankatu 7", "02600", "Espoo", "Sweden"));

        // Test equality for the same address with different country
        assertNotEquals(address, new Address("Mannerheimintie 100", "00100", "Helsinki", "Sweden"));
    }

    @Test
    public void testToString() {
        String expected = "Address{streetAddress='Mannerheimintie 100', zipCode='00100', postalDistrict='Helsinki', country='Finland'}";
        assertEquals(expected, address.toString());
    }
}
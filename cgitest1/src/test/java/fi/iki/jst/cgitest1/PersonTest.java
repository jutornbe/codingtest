package fi.iki.jst.cgitest1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fi.iki.jst.cgitest1.model.Person;

public class PersonTest {

    private Person person1;
    private Person person2;

    @BeforeEach
    public void setUp() {
        person1 = new Person(1, "120190-1234", "Tavallinen", "Teppo", "teppo.tavallinen@iki.fi", "040-1234567", "Mannerheimintie 100", "00100", "Helsinki", "Finland");
        person2 = new Person(2, "120191-4321", "Erikoinen", "Erkki", "erkki.erikoinen@aalto.fi", "044-7654321", "Leppävaarankatu 7", "02600", "Espoo", "Finland");
    }


    @Test
    public void testGetAndSetId() {
        assertEquals(1, person1.getId());
        person1.setId(2);
        assertEquals(2, person1.getId());
    }

    @Test
    public void testGetAndSetPersonalIdentificationNumber() {
        assertEquals("120190-1234", person1.getPersonalIdentificationNumber());
        person1.setPersonalIdentificationNumber("120192-4320");
        assertEquals("120192-4320", person1.getPersonalIdentificationNumber());
    }

    @Test
    public void testGetAndSetSurName() {
        assertEquals("Tavallinen", person1.getSurName());
        person1.setSurName("Erikoinen");
        assertEquals("Erikoinen", person1.getSurName());
    }   

    @Test
    public void testGetAndSetFirstNames() {
        assertEquals("Teppo", person1.getFirstNames());
        person1.setFirstNames("Erkki");
        assertEquals("Erkki", person1.getFirstNames());
    }

    @Test
    public void testEquals() {
        // Test equality for different instances of the same person
        assertEquals(person1, new Person(1, "120190-1234", "Tavallinen", "Teppo", "teppo.tavallinen@iki.fi", "040-1234567", "Mannerheimintie 100", "00100", "Helsinki", "Finland"));

        // Test equality for different persons
        assertNotEquals(person1, person2);

        // Test equality for the same person with different ID
        assertNotEquals(person1, new Person(4, "120190-1234", "Tavallinen", "Teppo", "teppo.tavallinen@iki.fi", "040-1234567", "Mannerheimintie 100", "00100", "Helsinki", "Finland"));
    }

    @Test
    public void testToString() {
        String expected = "Person{id=1, personalIdentificationNumber='120190-1234', surName='Tavallinen', firstNames='Teppo', email='teppo.tavallinen@iki.fi', telephone='040-1234567', address='Address{streetAddress='Mannerheimintie 100', zipCode='00100', postalDistrict='Helsinki', country='Finland'}'}";
        assertEquals(expected, person1.toString());
    }
}

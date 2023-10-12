package fi.iki.jst.cgitest1.service;

import javax.validation.Valid;

import java.util.List;
import org.springframework.stereotype.Service;
import fi.iki.jst.cgitest1.model.Person;
import java.util.ArrayList;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<>();
    private long nextId = 0;

    // Add person
    public Person addPerson(@Valid Person person) {
        person.setId(nextId);
        persons.add(person);
        nextId++;
        return person;
    }
    
    // Get all persons
    public List<Person> getAllPersons() {
        return persons;
    }
    
    // Get person by id
    public Person getPersonById(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id must be natural number.");
        }
        for (Person person : persons) {
            if (id == person.getId()) {
                return person;
            }
        }
        return null; // Henkilöä ei löytynyt
    }
    
    // Update person
    public Person updatePerson(Long id, @Valid Person updatedPerson) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id must be natural number.");
        }

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            if (id == person.getId()) {
                updatedPerson.setId(id);
                persons.set(i, updatedPerson);
                return updatedPerson;
            }
        }
        return null; // Henkilöä ei löytynyt
   }
    
    // Remove person by id
    public void deletePerson(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id must be natural number.");
        }
        persons.removeIf(person -> id == person.getId());
    }
}

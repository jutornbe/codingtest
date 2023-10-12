package fi.iki.jst.cgitest1.controller;
import fi.iki.jst.cgitest1.model.Person;
import fi.iki.jst.cgitest1.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id must be natural number.");
        }
        return personService.getPersonById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Person addPerson(@Valid @RequestBody Person person) {        
        return personService.addPerson(person);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @Valid @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id must be natural number.");
        }
        personService.deletePerson(id);
    }
}

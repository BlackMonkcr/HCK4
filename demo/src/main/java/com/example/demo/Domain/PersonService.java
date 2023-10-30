package com.example.demo.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Infrastructure.PersonRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    public Set<Groups> getGroupsByPerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return person.getGroups();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}

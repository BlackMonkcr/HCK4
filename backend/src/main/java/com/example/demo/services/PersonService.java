package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public void create(Person person){
        repository.save(person);
    }

    public Person read(Long id) {
        return repository.findById(id).get();
    }

    public List<Person> read(){
        return repository.findAll();
    }

    public Person update(Long id, Person p){
        return repository.save(p);
    }

    public void delete(Long id){
        Person person;
        person = repository.findById(id).get();
    }

}

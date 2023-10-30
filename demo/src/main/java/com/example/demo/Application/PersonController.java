package com.example.demo.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import com.example.demo.Domain.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    //POST: crea una persona
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    //GET: recupera todas las personas
    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personService.getPersons(),HttpStatus.OK);
    }

    //GET: Recupera una persona por id
    @GetMapping("/{id}")
    public ResponseEntity<Person> person(@PathVariable Long id){
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    //GET: Recupera a la persona que perstenece a tantos grupos
    @GetMapping("/groups/{id}")
    public ResponseEntity<Set<Groups>> getGroupsByPerson(@PathVariable Long id){
        Set<Groups> groups= personService.getGroupsByPerson(id);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }
}
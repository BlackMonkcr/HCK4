package com.example.demo.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import com.example.demo.Domain.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    //POST: crea un nuevo grupo
    @PostMapping
    public ResponseEntity<Groups> createGroup(@RequestBody Groups groups){
        return new ResponseEntity<>(groupService.saveGroup(groups), HttpStatus.CREATED);
    }

    //GET: recupera todos los groups
    @GetMapping
    public ResponseEntity<List<Groups>> getAllGroups(){
        return new ResponseEntity<>(groupService.getGroups(),HttpStatus.OK);
    }

    //GET: Recupera un grupo por id
    @GetMapping("/{id}")
    public ResponseEntity<Groups> group(@PathVariable Long id){
        return new ResponseEntity<>(groupService.getGroupById(id),HttpStatus.OK);
    }

    //GET: Recupera al grupo con las personas que tiene
    @GetMapping("/persons/{id}")
    public ResponseEntity<Set<Person>> getPersonsByGroup(@PathVariable Long id){
        Set<Person> persons= groupService.getPersonsByGroup(id);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
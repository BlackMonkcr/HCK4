package com.example.demo.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Infrastructure.*;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JoinService {
    private final PersonRepository personRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public JoinService(PersonRepository personRepository, GroupRepository groupRepository) {
        this.personRepository = personRepository;
        this.groupRepository = groupRepository;
    }

    public void joinGroup(Long personId, Long groupId) {
        Person person = personRepository.findById(personId).orElseThrow();
        Groups group = groupRepository.findById(groupId).orElseThrow();
        Set<Groups> groups = person.getGroups();
        groups.add(group);
        Set<Person> persons = group.getPersons();
        persons.add(person);

        person.setGroups(groups);
        group.setPersons(persons);
        personRepository.save(person);
        groupRepository.save(group);
    }

    public void leaveGroup(Long personId, Long groupId) {
        Person person = personRepository.findById(personId).orElseThrow();
        Groups group = groupRepository.findById(groupId).orElseThrow();
        Set<Groups> groups = person.getGroups();
        groups.remove(group);
        Set<Person> persons = group.getPersons();
        persons.remove(person);

        person.setGroups(groups);
        group.setPersons(persons);
        personRepository.save(person);
        groupRepository.save(group);
    }
}

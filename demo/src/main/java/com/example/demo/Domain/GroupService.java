package com.example.demo.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Infrastructure.GroupRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Groups> getGroups() {
        return groupRepository.findAll();
    }

    public Groups getGroupById(Long id) {
        Optional<Groups> group = groupRepository.findById(id);
        return group.orElse(null);
    }

    public Set<Person> getPersonsByGroup(Long id) {
        Groups groups = groupRepository.findById(id).orElseThrow();
        return groups.getPersons();
    }

    public Groups saveGroup(Groups groups) {
        return groupRepository.save(groups);
    }
}

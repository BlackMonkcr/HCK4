package com.example.demo.services;

import com.example.demo.model.Grupo;
import com.example.demo.model.Person;
import com.example.demo.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GrupoService {
    @Autowired
    private GrupoRepository repository;

    public void create(Grupo grupo){
        repository.save(grupo);
    }

    public Grupo read(Long id) {
        return repository.findById(id).get();
    }

    public List<Grupo> read(){
        return repository.findAll();
    }

    public Grupo update(Long id, Grupo p){
        return repository.save(p);
    }

    public void delete(Long id){
        Grupo person;
        person = repository.findById(id).get();
    }

    public Grupo getGrupoById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

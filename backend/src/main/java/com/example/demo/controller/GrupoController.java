package com.example.demo.controller;

import com.example.demo.model.Grupo;
import com.example.demo.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@CrossOrigin(origins = "*")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @PostMapping
    public void create(@RequestBody Grupo grupo) {
        service.create(grupo);
    }

    @GetMapping
    public List<Grupo> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public Grupo read(@PathVariable Long id) {
        return service.read(id);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Grupo grupo, @PathVariable Long id) {
        service.update(id, grupo);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

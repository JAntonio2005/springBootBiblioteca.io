package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.Genero;
import com.example.BibliotecaPechugones.repository.GeneroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin("*")
public class GeneroController {

    private final GeneroRepository generoRepository;

    public GeneroController(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @GetMapping
    public List<Genero> getAll() {
        return generoRepository.findAll();
    }

    @PostMapping
    public Genero create(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

    @PutMapping("/{id}")
    public Genero update(@PathVariable Long id, @RequestBody Genero genero) {
        genero.setId_genero(id);
        return generoRepository.save(genero);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        generoRepository.deleteById(id);
    }
}
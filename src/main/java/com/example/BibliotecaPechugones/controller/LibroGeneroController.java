package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.LibroGenero;
import com.example.BibliotecaPechugones.repository.LibroGeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librogenero")
@CrossOrigin("*")
public class LibroGeneroController {

    @Autowired
    private LibroGeneroRepository libroGeneroRepository;

    @GetMapping
    public List<LibroGenero> getAll() {
        return libroGeneroRepository.findAll();
    }

    @PostMapping
    public LibroGenero create(@RequestBody LibroGenero libroGenero) {
        return libroGeneroRepository.save(libroGenero);
    }

    @DeleteMapping("/{idLibro}/{idGenero}")
    public void delete(@PathVariable Long idLibro, @PathVariable Long idGenero) {
        libroGeneroRepository.deleteById(new LibroGenero.LibroGeneroId(idLibro, idGenero));
    }
}

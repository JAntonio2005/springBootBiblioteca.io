package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.Libro;
import com.example.BibliotecaPechugones.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libroDetails) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if (libro != null) {
            libro.setTitulo(libroDetails.getTitulo());
            libro.setAutor(libroDetails.getAutor());
            return libroRepository.save(libro);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }
}

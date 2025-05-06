package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.Prestamo;
import com.example.BibliotecaPechugones.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin("*")
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @PostMapping
    public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @GetMapping("/{id}")
    public Prestamo getPrestamoById(@PathVariable Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Prestamo updatePrestamo(@PathVariable Long id, @RequestBody Prestamo prestamoDetails) {
        Prestamo prestamo = prestamoRepository.findById(id).orElse(null);
        if (prestamo != null) {
            prestamo.setFechaPrestamo(prestamoDetails.getFechaPrestamo());
            prestamo.setFechaDevolucion(prestamoDetails.getFechaDevolucion());
            prestamo.setEstado(prestamoDetails.getEstado());
            return prestamoRepository.save(prestamo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePrestamo(@PathVariable Long id) {
        prestamoRepository.deleteById(id);
    }
}

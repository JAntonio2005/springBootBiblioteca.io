package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.Miembro;
import com.example.BibliotecaPechugones.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
@CrossOrigin("*")
public class MiembroController {

    @Autowired
    private MiembroRepository miembroRepository;

    @GetMapping
    public List<Miembro> getAllMiembros() {
        return miembroRepository.findAll();
    }

    @PostMapping
    public Miembro createMiembro(@RequestBody Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    @GetMapping("/{id}")
    public Miembro getMiembroById(@PathVariable Long id) {
        return miembroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Miembro updateMiembro(@PathVariable Long id, @RequestBody Miembro miembroDetails) {
        Miembro miembro = miembroRepository.findById(id).orElse(null);
        if (miembro != null) {
            miembro.setNombre(miembroDetails.getNombre());
            miembro.setApellidos(miembroDetails.getApellidos());
            miembro.setTelefono(miembroDetails.getTelefono());
            return miembroRepository.save(miembro);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMiembro(@PathVariable Long id) {
        miembroRepository.deleteById(id);
    }
}

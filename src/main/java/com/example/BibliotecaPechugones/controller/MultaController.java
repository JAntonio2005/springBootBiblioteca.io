package com.example.BibliotecaPechugones.controller;
import com.example.BibliotecaPechugones.model.Multa;
import com.example.BibliotecaPechugones.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/multas")
@CrossOrigin("*")
public class MultaController {

    @Autowired
    private MultaRepository multaRepository;

    @GetMapping
    public List<Multa> getAllMultas() {
        return multaRepository.findAll();
    }

    @PostMapping
    public Multa createMulta(@RequestBody Multa multa) {
        return multaRepository.save(multa);
    }

    @GetMapping("/{id}")
    public Multa getMultaById(@PathVariable Long id) {
        return multaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Multa updateMulta(@PathVariable Long id, @RequestBody Multa multaDetails) {
        Multa multa = multaRepository.findById(id).orElse(null);
        if (multa != null) {
            multa.setFechaMulta(multaDetails.getFechaMulta());
            multa.setMotivo(multaDetails.getMotivo());
            multa.setMonto(multaDetails.getMonto());
            return multaRepository.save(multa);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMulta(@PathVariable Long id) {
        multaRepository.deleteById(id);
    }
}

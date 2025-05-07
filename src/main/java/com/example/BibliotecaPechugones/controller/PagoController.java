package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.Pago;
import com.example.BibliotecaPechugones.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin("*")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    @PostMapping
    public Pago createPago(@RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }

    @GetMapping("/{id}")
    public Pago getPagoById(@PathVariable Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pago updatePago(@PathVariable Long id, @RequestBody Pago pagoDetails) {
        Pago pago = pagoRepository.findById(id).orElse(null);
        if (pago != null) {
            pago.setIdMiembro(pagoDetails.getIdMiembro());
            pago.setIdVenta(pagoDetails.getIdVenta());
            pago.setMonto(pagoDetails.getMonto());
            pago.setFecha(pagoDetails.getFecha());
            return pagoRepository.save(pago);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable Long id) {
        pagoRepository.deleteById(id);
    }
}

package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.Venta;
import com.example.BibliotecaPechugones.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin("*")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaRepository.save(venta);
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Venta updateVenta(@PathVariable Long id, @RequestBody Venta ventaDetails) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta != null) {
            venta.setFechaVenta(ventaDetails.getFechaVenta());
            venta.setMetodoPago(ventaDetails.getMetodoPago());
            return ventaRepository.save(venta);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaRepository.deleteById(id);
    }
}

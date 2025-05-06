package com.example.BibliotecaPechugones.controller;

import com.example.BibliotecaPechugones.model.Empleado;
import com.example.BibliotecaPechugones.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin("*")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetails) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            empleado.setNombre(empleadoDetails.getNombre());
            empleado.setApellidos(empleadoDetails.getApellidos());
            empleado.setTurno(empleadoDetails.getTurno());
            return empleadoRepository.save(empleado);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoRepository.deleteById(id);
    }
}

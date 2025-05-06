package com.example.BibliotecaPechugones.repository;


import com.example.BibliotecaPechugones.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}

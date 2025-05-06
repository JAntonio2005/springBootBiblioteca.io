package com.example.BibliotecaPechugones.repository;

import com.example.BibliotecaPechugones.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}

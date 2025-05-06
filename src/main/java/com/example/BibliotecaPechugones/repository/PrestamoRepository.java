package com.example.BibliotecaPechugones.repository;

import com.example.BibliotecaPechugones.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}

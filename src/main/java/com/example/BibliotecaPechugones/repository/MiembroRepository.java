package com.example.BibliotecaPechugones.repository;

import com.example.BibliotecaPechugones.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro, Long> {
}

package com.example.BibliotecaPechugones.repository;

import com.example.BibliotecaPechugones.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {
}

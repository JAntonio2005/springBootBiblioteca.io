package com.example.BibliotecaPechugones.repository;

import com.example.BibliotecaPechugones.model.LibroGenero;
import com.example.BibliotecaPechugones.model.LibroGenero.LibroGeneroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroGeneroRepository extends JpaRepository<LibroGenero, LibroGeneroId> {
}

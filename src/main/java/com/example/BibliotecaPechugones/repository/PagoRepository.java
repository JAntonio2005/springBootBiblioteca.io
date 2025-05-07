package com.example.BibliotecaPechugones.repository;

import com.example.BibliotecaPechugones.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}

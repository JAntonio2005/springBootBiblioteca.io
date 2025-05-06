package com.example.BibliotecaPechugones.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "libro_genero")
@IdClass(LibroGenero.LibroGeneroId.class)
public class LibroGenero {

    @Id
    @Column(name = "id_libro")
    private Long idLibro;

    @Id
    @Column(name = "id_genero")
    private Long idGenero;

    // Getters y Setters

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    // Clase embebida para clave compuesta
    public static class LibroGeneroId implements Serializable {
        private Long idLibro;
        private Long idGenero;

        public LibroGeneroId() {}

        public LibroGeneroId(Long idLibro, Long idGenero) {
            this.idLibro = idLibro;
            this.idGenero = idGenero;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LibroGeneroId that = (LibroGeneroId) o;
            return Objects.equals(idLibro, that.idLibro) &&
                   Objects.equals(idGenero, that.idGenero);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idLibro, idGenero);
        }
    }
}

package com.fixfinder.fixfinderback.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoUsuario;

    private String descripcion; // Ej. "Cliente", "Especialista"


    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

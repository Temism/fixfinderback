package com.fixfinder.fixfinderback.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidad;

    private String descripcion; // Descripción de la especialidad ej:(plomero,electricista,albañil,etc)

    @ManyToMany(mappedBy = "especialidades")
    @JsonIgnore
    private List<Usuario> usuarios;

}


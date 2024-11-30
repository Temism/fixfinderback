package com.fixfinder.fixfinderback.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String ApPaterno;
    private String ApMaterno;
    private String email;
    private String telefono;
    private String contrasena;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario; // Tipo de usuario (cliente, especialista)

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas; // Las reservas realizadas por el usuario

    @ManyToMany
    @JoinTable(
            name = "usuario_especialidad",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idEspecialidad")
    )
    private List<Especialidad> especialidades; // Especialidades del usuario



}



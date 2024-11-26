package com.fixfinder.fixfinderback.repositorio;

import com.fixfinder.fixfinderback.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRep extends JpaRepository<Usuario,Long> {

}

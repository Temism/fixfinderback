package com.fixfinder.fixfinderback.repositorio;

import com.fixfinder.fixfinderback.Models.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRep extends JpaRepository<TipoUsuario,Long> {
}

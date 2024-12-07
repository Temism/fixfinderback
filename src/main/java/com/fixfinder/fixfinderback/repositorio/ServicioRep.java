package com.fixfinder.fixfinderback.repositorio;

import com.fixfinder.fixfinderback.Models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRep extends JpaRepository<Servicio,Long> {

    List<Servicio> findByUsuarioIdUsuario(Long idUsuario);
}

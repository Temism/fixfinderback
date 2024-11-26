package com.fixfinder.fixfinderback.repositorio;

import com.fixfinder.fixfinderback.Models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRep extends JpaRepository<Servicio,Long> {
}

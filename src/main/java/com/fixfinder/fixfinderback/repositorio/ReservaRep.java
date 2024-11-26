package com.fixfinder.fixfinderback.repositorio;

import com.fixfinder.fixfinderback.Models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRep extends JpaRepository<Reserva,Long> {
}

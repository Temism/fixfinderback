package com.fixfinder.fixfinderback.repositorio;

import com.fixfinder.fixfinderback.Models.Resena;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResenaRep extends JpaRepository<Resena,Long> {

}

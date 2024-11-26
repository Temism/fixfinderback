package com.fixfinder.fixfinderback.Services;

import com.fixfinder.fixfinderback.Models.Resena;
import com.fixfinder.fixfinderback.repositorio.ResenaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {

    @Autowired
    private ResenaRep resenaRepository;

    public Resena guardarResena(Resena resena) {
        return resenaRepository.save(resena);
    }

    public Optional<Resena> obtenerResenaPorId(Long id) {
        return resenaRepository.findById(id);
    }

    public List<Resena> obtenerTodasResenas() {
        return resenaRepository.findAll();
    }

    public void eliminarResena(Long id) {
        resenaRepository.deleteById(id);
    }
}
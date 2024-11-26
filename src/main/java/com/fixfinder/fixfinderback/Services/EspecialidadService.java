package com.fixfinder.fixfinderback.Services;


import com.fixfinder.fixfinderback.Models.Especialidad;
import com.fixfinder.fixfinderback.repositorio.EspecialidadRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRep especialidadRepository;

    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public Optional<Especialidad> obtenerEspecialidadPorId(Long id) {
        return especialidadRepository.findById(id);
    }

    public List<Especialidad> obtenerTodasEspecialidades() {
        return especialidadRepository.findAll();
    }

    public void eliminarEspecialidad(Long id) {
        especialidadRepository.deleteById(id);
    }

}

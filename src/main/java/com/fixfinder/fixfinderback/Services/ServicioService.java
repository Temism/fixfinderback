package com.fixfinder.fixfinderback.Services;

import com.fixfinder.fixfinderback.Models.Servicio;
import com.fixfinder.fixfinderback.repositorio.ServicioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    @Autowired
    private ServicioRep servicioRepository;

    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Optional<Servicio> obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id);
    }

    public List<Servicio> obtenerTodosServicios() {
        return servicioRepository.findAll();
    }

    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }

}

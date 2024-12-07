package com.fixfinder.fixfinderback.Services;

import com.fixfinder.fixfinderback.Models.Servicio;
import com.fixfinder.fixfinderback.Models.Usuario;
import com.fixfinder.fixfinderback.repositorio.ServicioRep;
import com.fixfinder.fixfinderback.repositorio.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    @Autowired
    private ServicioRep servicioRepository;

    @Autowired
    private UsuarioRep usuarioRepository;

    public Servicio crearServicio(Servicio servicio, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        servicio.setUsuario(usuario);
        return servicioRepository.save(servicio);
    }

    public List<Servicio> obtenerServiciosPorUsuario(Long idUsuario) {
        return servicioRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public List<Servicio> obtenerTodosServicios() {
        return servicioRepository.findAll();
    }

    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }

    public Servicio actualizarServicio(Long id, Servicio servicioActualizado) {
        return servicioRepository.findById(id)
                .map(servicio -> {
                    servicio.setNombreServicio(servicioActualizado.getNombreServicio());
                    servicio.setDescripcionServicio(servicioActualizado.getDescripcionServicio());
                    servicio.setValorServicio(servicioActualizado.getValorServicio());
                    servicio.setHorario(servicioActualizado.getHorario());
                    return servicioRepository.save(servicio);
                })
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

}

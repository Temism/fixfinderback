package com.fixfinder.fixfinderback.Services;
import com.fixfinder.fixfinderback.Models.Reserva;
import com.fixfinder.fixfinderback.repositorio.ReservaRep;
import com.fixfinder.fixfinderback.repositorio.ServicioRep;
import com.fixfinder.fixfinderback.repositorio.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    @Autowired
    private ReservaRep reservaRepository;

    @Autowired
    private UsuarioRep usuarioRepository;

    @Autowired
    private ServicioRep servicioRepository;

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public List<Reserva> obtenerTodasReservas() {
        return reservaRepository.findAll();
    }

    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<Reserva> obtenerReservasPorUsuario(Long usuarioId) {
        return reservaRepository.findAll().stream()
                .filter(reserva -> reserva.getUsuario().getIdUsuario().equals(usuarioId))
                .collect(Collectors.toList());
    }

}

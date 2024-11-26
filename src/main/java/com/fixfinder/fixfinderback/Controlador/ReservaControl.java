package com.fixfinder.fixfinderback.Controlador;

import com.fixfinder.fixfinderback.Models.Reserva;
import com.fixfinder.fixfinderback.Services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaControl {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        return new ResponseEntity<>(reservaService.guardarReserva(reserva), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id) {
        return reservaService.obtenerReservaPorId(id)
                .map(reserva -> new ResponseEntity<>(reserva, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Reserva> obtenerTodasReservas() {
        return reservaService.obtenerTodasReservas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

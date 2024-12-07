package com.fixfinder.fixfinderback.Controlador;

import com.fixfinder.fixfinderback.Models.Servicio;
import com.fixfinder.fixfinderback.Services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioControl {

    @Autowired
    private ServicioService servicioService;

    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<Servicio> crearServicio(@PathVariable Long idUsuario, @RequestBody Servicio servicio) {
        Servicio nuevoServicio = servicioService.crearServicio(servicio, idUsuario);
        return new ResponseEntity<>(nuevoServicio, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Servicio>> obtenerServiciosPorUsuario(@PathVariable Long idUsuario) {
        List<Servicio> servicios = servicioService.obtenerServiciosPorUsuario(idUsuario);
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> obtenerTodosServicios() {
        List<Servicio> servicios = servicioService.obtenerTodosServicios();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable Long id, @RequestBody Servicio servicio) {
        Servicio servicioActualizado = servicioService.actualizarServicio(id, servicio);
        return new ResponseEntity<>(servicioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


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

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        return new ResponseEntity<>(servicioService.guardarServicio(servicio), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable Long id) {
        return servicioService.obtenerServicioPorId(id)
                .map(servicio -> new ResponseEntity<>(servicio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Servicio> obtenerTodosServicios() {
        return servicioService.obtenerTodosServicios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


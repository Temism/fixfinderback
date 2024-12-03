package com.fixfinder.fixfinderback.Controlador;

import com.fixfinder.fixfinderback.Models.Especialidad;
import com.fixfinder.fixfinderback.Services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/especialidades")
public class EspecialidadControl{

    @Autowired
    private EspecialidadService especialidadService;

    @PostMapping
    public ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(especialidadService.guardarEspecialidad(especialidad), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerEspecialidadPorId(@PathVariable Long id) {
        return especialidadService.obtenerEspecialidadPorId(id)
                .map(especialidad -> new ResponseEntity<>(especialidad, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Especialidad> obtenerTodasEspecialidades() {
        return especialidadService.obtenerTodasEspecialidades();
    }


}

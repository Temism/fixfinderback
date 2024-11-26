package com.fixfinder.fixfinderback.Controlador;

import com.fixfinder.fixfinderback.Models.Resena;
import com.fixfinder.fixfinderback.Services.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resenas")
@CrossOrigin(origins = "http://localhost:4200")
public class ResenaControl {

    @Autowired
    private ResenaService resenaService;

    @PostMapping
    public ResponseEntity<Resena> crearResena(@RequestBody Resena resena) {
        return new ResponseEntity<>(resenaService.guardarResena(resena), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> obtenerResenaPorId(@PathVariable Long id) {
        return resenaService.obtenerResenaPorId(id)
                .map(resena -> new ResponseEntity<>(resena, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Resena> obtenerTodasResenas() {
        return resenaService.obtenerTodasResenas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Long id) {
        resenaService.eliminarResena(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

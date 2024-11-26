package com.fixfinder.fixfinderback.Controlador;

import com.fixfinder.fixfinderback.Models.TipoUsuario;
import com.fixfinder.fixfinderback.Services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipos-usuario")
public class TipoUsuarioControl {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping
    public ResponseEntity<TipoUsuario> crearTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return new ResponseEntity<>(tipoUsuarioService.guardarTipoUsuario(tipoUsuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> obtenerTipoUsuarioPorId(@PathVariable Long id) {
        return tipoUsuarioService.obtenerTipoUsuarioPorId(id)
                .map(tipoUsuario -> new ResponseEntity<>(tipoUsuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<TipoUsuario> obtenerTodosTipoUsuarios() {
        return tipoUsuarioService.obtenerTodosTipoUsuarios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoUsuario(@PathVariable Long id) {
        tipoUsuarioService.eliminarTipoUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

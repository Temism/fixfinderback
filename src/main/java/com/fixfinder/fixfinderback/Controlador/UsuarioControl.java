package com.fixfinder.fixfinderback.Controlador;


import com.fixfinder.fixfinderback.Models.Reserva;
import com.fixfinder.fixfinderback.Models.Usuario;
import com.fixfinder.fixfinderback.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControl {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/asignar-especialidades")
    public ResponseEntity<Void> asignarEspecialidades(
            @PathVariable Long id,
            @RequestBody List<Long> especialidadIds) {
        usuarioService.asignarEspecialidades(id, especialidadIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/especialidades")
    public List<String> obtenerEspecialidadesPorUsuario(@PathVariable Long id) {
        return usuarioService.obtenerEspecialidadesPorUsuario(id);
    }


    @GetMapping("/{id}/reservas")
    public ResponseEntity<List<Reserva>> obtenerReservasPorIdUsuario(@PathVariable Long id) {
        List<Reserva> reservas = usuarioService.obtenerReservasPorIdUsuario(id);
        if (reservas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/esp/{id}/reservas")
    public ResponseEntity<List<Reserva>> getReservasByEspecialista(@PathVariable Long id) {
        List<Reserva> reservas = usuarioService.getReservasByEspecialista(id);
        if (reservas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reservas);
    }


}


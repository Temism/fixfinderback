package com.fixfinder.fixfinderback.Controlador;

import com.fixfinder.fixfinderback.Models.Pago;
import com.fixfinder.fixfinderback.Services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoControl {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        return new ResponseEntity<>(pagoService.guardarPago(pago), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPagoPorId(@PathVariable Long id) {
        return pagoService.obtenerPagoPorId(id)
                .map(pago -> new ResponseEntity<>(pago, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Pago> obtenerTodosPagos() {
        return pagoService.obtenerTodosPagos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


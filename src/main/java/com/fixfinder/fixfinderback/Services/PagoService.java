package com.fixfinder.fixfinderback.Services;

import com.fixfinder.fixfinderback.Models.Pago;
import com.fixfinder.fixfinderback.repositorio.PagoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    @Autowired
    private PagoRep pagoRepository;

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Optional<Pago> obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public List<Pago> obtenerTodosPagos() {
        return pagoRepository.findAll();
    }

    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}

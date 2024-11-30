package com.fixfinder.fixfinderback.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private Integer valorPago;
    private Date fechaPago;
    private String estadoPago; // Ej. "Completado", "Pendiente"

    @OneToOne(mappedBy = "pago")
    private Reserva reserva; // La reserva asociada a este pago


}


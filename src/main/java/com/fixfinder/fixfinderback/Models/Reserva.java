package com.fixfinder.fixfinderback.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private Date fechaReserva;
    private String estadoReserva; // Ej. "Pendiente", "Confirmada", "Finalizada"
    private String horaReserva;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario; // El usuario que realiza la reserva

    @ManyToOne
    @JoinColumn(name = "idEspecialista")
    private Usuario especialista; // El especialista que atiende la reserva

    @ManyToMany
    @JoinTable(
            name = "reserva_servicio",
            joinColumns = @JoinColumn(name = "idReserva"),
            inverseJoinColumns = @JoinColumn(name = "idServicio")
    )
    private List<Servicio> servicios; // Los servicios asociados a la reserva

    @OneToOne
    @JoinColumn(name = "idResena")
    private Resena resena; // Reseña asociada a la reserva

    @OneToOne
    @JoinColumn(name = "idPago")
    private Pago pago; // Pago asociado a la reserva


}

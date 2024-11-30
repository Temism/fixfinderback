package com.fixfinder.fixfinderback.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResena;

    private String comentario;
    private Integer calificacion; // Por ejemplo, de 1 a 5

    @OneToOne(mappedBy = "resena")
    private Reserva reserva; // La reserva asociada a esta reseña


}


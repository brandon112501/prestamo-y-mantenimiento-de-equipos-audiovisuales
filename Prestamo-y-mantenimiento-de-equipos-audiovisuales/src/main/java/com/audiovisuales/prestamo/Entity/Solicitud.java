package com.audiovisuales.prestamo.Entity;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false, length = 255)
    private String motivo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitante_id",nullable = false)
    private Usuario solicitante;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id",nullable = false)
    private Estado estado;
}


package com.audiovisuales.prestamo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mantenimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(columnDefinition = "TEXT")
    private String diagnostico;

    private Double costo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id",nullable = false)
    private Equipo equipo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id",nullable = false)
    private Estado estado;




}

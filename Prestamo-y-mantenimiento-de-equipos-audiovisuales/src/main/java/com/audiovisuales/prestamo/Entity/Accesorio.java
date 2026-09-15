package com.audiovisuales.prestamo.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accesorios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accesorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false)
    private Integer cantidad;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "equipo_asociado_id",nullable = false)
    private Equipo equipoAsociado;

}
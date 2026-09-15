package com.audiovisuales.prestamo.Entity;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_inventario", nullable = false, unique = true)
    private String codigoInventario;

    @Column(nullable = false ,length = 50)
    private String tipo;


    @Column(nullable = false,length = 50)
    private String marca;


    @Column(nullable = false,length = 50)
    private String modelo;

    @Column(nullable = false, length = 100)
    private String ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id",nullable = false)
    private Estado estado;
}

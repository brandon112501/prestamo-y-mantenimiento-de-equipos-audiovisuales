package com.audiovisuales.prestamo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Estado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre_estado", nullable = false, length = 50)
    private String nombreEstado;

    @Column (nullable = false, length = 50)
    private String modulo;

}

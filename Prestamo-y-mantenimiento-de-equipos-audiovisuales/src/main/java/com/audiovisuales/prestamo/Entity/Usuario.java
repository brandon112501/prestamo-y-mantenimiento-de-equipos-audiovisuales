package com.audiovisuales.prestamo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, length = 255)
    private String contrasena;

    @Column (nullable = false,length = 100)
    private String unidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id",nullable = false)
    private Rol rol;

}

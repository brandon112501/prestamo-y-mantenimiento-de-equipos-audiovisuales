package com.audiovisuales.prestamo.Dto.RequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequestDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Email(message = "Correo inválido")
    private String correo;
    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;
}
package com.audiovisuales.prestamo.Dto.RequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDto {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;


    @Email(message = "Correo inválido")
    @NotBlank(message = "El correo es obligatorio")
    @Size(max = 100, message = "El correo no puede superar los 100 caracteres")
    private String correo;


    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 255, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;

    @NotBlank(message = "La unidad es obligatoria")
    @Size(max = 100, message = "La unidad no puede superar los 100 caracteres")
    private String unidad;

    @NotNull(message = "El ID del rol es obligatorio")
    private Long rolId;
}
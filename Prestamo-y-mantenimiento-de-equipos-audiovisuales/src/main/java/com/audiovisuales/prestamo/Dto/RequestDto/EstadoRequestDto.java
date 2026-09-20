package com.audiovisuales.prestamo.Dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoRequestDto {

    @NotBlank(message = "El nombre del estado es obligatorio")
    @Size(max = 50, message = "El nombre del estado no puede superar los 50 caracteres")
    private String nombreEstado;

    @NotBlank(message = "El módulo es obligatorio")
    @Size(max = 50, message = "El módulo no puede superar los 50 caracteres")
    private String modulo;
}
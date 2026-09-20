package com.audiovisuales.prestamo.Dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MantenimientoRequestDto {

    @NotBlank(message = "El tipo de mantenimiento es obligatorio")
    @Size(max = 50, message = "El tipo no puede superar los 50 caracteres")
    private String tipo;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    private String diagnostico;

    private Double costo;

    @NotNull(message = "El ID del equipo es obligatorio")
    private Long equipoId;

    @NotNull(message = "El ID del estado es obligatorio")
    private Long estadoId;
}
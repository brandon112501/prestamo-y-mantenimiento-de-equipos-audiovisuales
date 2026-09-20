package com.audiovisuales.prestamo.Dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoRequestDto {

    @NotBlank(message = "El código de inventario es obligatorio")
    @Size(max = 50, message = "El código de inventario no puede superar los 50 caracteres")
    private String codigoInventario;

    @NotBlank(message = "El tipo de equipo es obligatorio")
    private String tipo;

    private String marca;
    private String modelo;
    private String ubicacion;

    @NotNull(message = "El ID del estado es obligatorio")
    private Long estadoId;
}
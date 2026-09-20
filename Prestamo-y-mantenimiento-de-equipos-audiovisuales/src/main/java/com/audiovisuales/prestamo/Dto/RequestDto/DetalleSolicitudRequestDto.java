package com.audiovisuales.prestamo.Dto.RequestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleSolicitudRequestDto {

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;

    @NotNull(message = "El ID de la solicitud es obligatorio")
    private Long solicitudId;

    @NotNull(message = "El ID del equipo es obligatorio")
    private Long equipoId;
}
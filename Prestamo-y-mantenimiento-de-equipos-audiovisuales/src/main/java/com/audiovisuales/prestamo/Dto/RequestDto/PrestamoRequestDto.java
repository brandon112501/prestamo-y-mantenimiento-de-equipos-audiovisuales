package com.audiovisuales.prestamo.Dto.RequestDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoRequestDto {

    @NotNull(message = "La fecha de entrega es obligatoria")
    private LocalDateTime fechaEntrega;

    private LocalDateTime fechaDevolucion;

    @Size(max = 50, message = "El estado inicial no puede superar los 50 caracteres")
    private String estadoInicial;

    @Size(max = 50, message = "El estado final no puede superar los 50 caracteres")
    private String estadoFinal;

    private String novedades;

    @NotNull(message = "El ID de la solicitud es obligatorio")
    private Long solicitudId;

    @NotNull(message = "El ID del responsable es obligatorio")
    private Long responsableId;

    @NotNull(message = "El ID del estado es obligatorio")
    private Long estadoId;
}
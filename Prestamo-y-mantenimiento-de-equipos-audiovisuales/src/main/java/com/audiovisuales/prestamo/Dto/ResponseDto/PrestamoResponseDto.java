package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoResponseDto {

    private Long id;
    private LocalDateTime fechaEntrega;
    private LocalDateTime fechaDevolucion;
    private String estadoInicial;
    private String estadoFinal;
    private String novedades;

  //relaciones
    private Long solicitudId;

    private Long responsableId;
    private String nombreResponsable;

    private Long estadoId;
    private String nombreEstado;
}
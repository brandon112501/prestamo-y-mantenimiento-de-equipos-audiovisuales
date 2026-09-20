package com.audiovisuales.prestamo.Dto.ResponseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudResponseDto {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String motivo;

    //datos Usuario
    private Long usuarioId;
    private String nombreSolicitante;


    //datos de Estado
    private String estadoId;
    private String nombreEstado;
}
package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleSolicitudResponseDto {

    private Long id;
    private Integer cantidad;

    private Long solicitudId;

    private Long equipoId;
    private String codigoEquipo;
}
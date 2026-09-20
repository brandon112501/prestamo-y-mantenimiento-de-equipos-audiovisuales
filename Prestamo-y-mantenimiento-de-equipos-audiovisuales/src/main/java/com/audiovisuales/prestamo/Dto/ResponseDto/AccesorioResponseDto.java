package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccesorioResponseDto {

    private Long id;
    private String nombre;
    private Integer cantidad;

    private Long equipoAsociadoId;
    private String codigoEquipoAsociado;
}
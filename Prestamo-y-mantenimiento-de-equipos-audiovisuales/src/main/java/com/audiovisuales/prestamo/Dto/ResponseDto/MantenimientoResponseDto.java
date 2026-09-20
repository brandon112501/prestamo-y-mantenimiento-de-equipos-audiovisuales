package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MantenimientoResponseDto {

    private Long id;
    private String tipo;
    private LocalDate fecha;
    private String diagnostico;
    private Double costo;

    private Long equipoId;
    private String codigoEquipo;

    private Long estadoId;
    private String nombreEstado;
}
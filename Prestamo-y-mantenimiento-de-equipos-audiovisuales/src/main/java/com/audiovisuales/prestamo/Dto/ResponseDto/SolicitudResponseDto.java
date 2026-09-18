package com.audiovisuales.prestamo.Dto.ResponseDto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class SolicitudResponseDto {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String motivo;
    private String estado;
    private Long usuarioId;
}
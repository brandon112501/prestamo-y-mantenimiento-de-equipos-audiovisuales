package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PrestamoResponseDto {
    private Long id;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private String observaciones;
    private String estado;
    private String novedades;
    private String estadoFinal;
}

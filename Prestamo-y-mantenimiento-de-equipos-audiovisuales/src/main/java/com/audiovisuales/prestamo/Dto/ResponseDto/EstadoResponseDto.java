package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoResponseDto {

    private Long id;
    private String nombreEstado;
    private String modulo;
}
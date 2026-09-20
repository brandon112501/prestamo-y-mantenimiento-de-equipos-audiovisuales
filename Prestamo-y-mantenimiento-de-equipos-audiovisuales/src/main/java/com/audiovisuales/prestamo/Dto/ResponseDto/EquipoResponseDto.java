package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoResponseDto {

    private Long id;
    private String codigoInventario;
    private String tipo;
    private String marca;
    private String modelo;
    private String ubicacion;
    private Long estadoId;
    private String nombreEstado;
}
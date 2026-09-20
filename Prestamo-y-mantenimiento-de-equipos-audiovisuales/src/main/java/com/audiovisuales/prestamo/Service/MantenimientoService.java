package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.MantenimientoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.MantenimientoResponseDto;

import java.util.List;

public interface MantenimientoService {

    List<MantenimientoResponseDto> obtenerTodos();

    MantenimientoResponseDto obtenerPorId(Long id);

    MantenimientoResponseDto crear(MantenimientoRequestDto request);

    MantenimientoResponseDto actualizar(Long id, MantenimientoRequestDto request);

    void eliminar(Long id);
}
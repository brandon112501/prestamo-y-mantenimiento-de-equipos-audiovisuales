package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.EquipoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.EquipoResponseDto;

import java.util.List;

public interface EquipoService {

    List<EquipoResponseDto> obtenerTodos();

    EquipoResponseDto obtenerPorId(Long id);

    EquipoResponseDto crear(EquipoRequestDto request);

    EquipoResponseDto actualizar(Long id, EquipoRequestDto request);

    void eliminar(Long id);
}
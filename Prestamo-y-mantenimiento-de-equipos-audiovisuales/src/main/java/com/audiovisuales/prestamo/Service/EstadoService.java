package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.EstadoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.EstadoResponseDto;

import java.util.List;

public interface EstadoService {

    List<EstadoResponseDto> obtenerTodos();

    EstadoResponseDto obtenerPorId(Long id);

    EstadoResponseDto crear(EstadoRequestDto request);

    EstadoResponseDto actualizar(Long id, EstadoRequestDto request);

    void eliminar(Long id);
}
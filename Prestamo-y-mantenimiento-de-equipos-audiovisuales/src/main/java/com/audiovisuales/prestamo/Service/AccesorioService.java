package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.AccesorioRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.AccesorioResponseDto;

import java.util.List;

public interface AccesorioService {

    List<AccesorioResponseDto> obtenerTodos();

    AccesorioResponseDto obtenerPorId(Long id);

    AccesorioResponseDto crear(AccesorioRequestDto request);

    AccesorioResponseDto actualizar(Long id, AccesorioRequestDto request);

    void eliminar(Long id);
}
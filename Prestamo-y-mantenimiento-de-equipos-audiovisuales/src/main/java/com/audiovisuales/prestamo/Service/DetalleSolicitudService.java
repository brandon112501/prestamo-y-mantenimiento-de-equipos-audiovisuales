package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.DetalleSolicitudRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.DetalleSolicitudResponseDto;

import java.util.List;

public interface DetalleSolicitudService {

    List<DetalleSolicitudResponseDto> obtenerTodos();

    DetalleSolicitudResponseDto obtenerPorId(Long id);

    DetalleSolicitudResponseDto crear(DetalleSolicitudRequestDto request);

    DetalleSolicitudResponseDto actualizar(Long id, DetalleSolicitudRequestDto request);

    void eliminar(Long id);
}
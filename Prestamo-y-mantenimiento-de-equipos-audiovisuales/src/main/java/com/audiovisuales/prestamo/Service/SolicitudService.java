package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.SolicitudRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.SolicitudResponseDto;
import com.audiovisuales.prestamo.Entity.Rol;
import com.audiovisuales.prestamo.Entity.Solicitud;
import java.util.List;

public interface SolicitudService {
    List<Solicitud> listarTodos();
    Solicitud obtenerPorId(Long id);
    SolicitudResponseDto crear(SolicitudRequestDto requestDto);
    Solicitud actualizar(Long id, Solicitud solicitud);
    void eliminar  (Long id);
}
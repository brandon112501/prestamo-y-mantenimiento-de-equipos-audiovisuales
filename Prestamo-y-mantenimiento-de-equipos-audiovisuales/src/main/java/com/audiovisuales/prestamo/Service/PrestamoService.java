package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.PrestamoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.PrestamoResponseDto;
import com.audiovisuales.prestamo.Entity.Prestamo;
import com.audiovisuales.prestamo.Entity.Rol;
import lombok.Data;

import java.util.List;

public interface PrestamoService {

    List<Prestamo> listarTodos();
    Prestamo obtenerPorId(Long id);
    PrestamoResponseDto crear(PrestamoRequestDto requestDto);
    Prestamo actualizar(Long id, Prestamo prestamo);
    void eliminar(Long id);
}
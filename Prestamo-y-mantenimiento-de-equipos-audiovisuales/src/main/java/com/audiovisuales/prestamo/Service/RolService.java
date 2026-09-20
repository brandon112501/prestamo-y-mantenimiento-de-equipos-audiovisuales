package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.RolRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.RolResponseDto;
import com.audiovisuales.prestamo.Entity.Rol;
import java.util.List;

public interface RolService {
    List<Rol> listarTodos();
    RolResponseDto obtenerPorId(Long id);
    RolResponseDto crear(RolRequestDto requestDto);
    RolResponseDto actualizar(Long id,RolRequestDto requestDto);
    void eliminar(Long id);

}


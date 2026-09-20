package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Dto.RequestDto.UsuarioRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.UsuarioResponseDto;
import com.audiovisuales.prestamo.Entity.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listarTodos();
    UsuarioResponseDto crear(UsuarioRequestDto requestDto);
    UsuarioResponseDto obtenerPorId(Long id);
    UsuarioResponseDto actualizar(Long id, UsuarioRequestDto requestDto);
    void eliminar(Long id);
}

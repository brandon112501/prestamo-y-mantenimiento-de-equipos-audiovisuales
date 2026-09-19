package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.UsuarioRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.UsuarioResponseDto;
import com.audiovisuales.prestamo.Entity.Usuario;
import com.audiovisuales.prestamo.Repository.UsuarioRepository;
import com.audiovisuales.prestamo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarTodos() {

        return usuarioRepository.findAll();
    }


    @Override
    public UsuarioResponseDto crear(UsuarioRequestDto requestDto) {

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(requestDto.getNombre());
        nuevoUsuario.setCorreo(requestDto.getCorreo());
        nuevoUsuario.setContrasena(requestDto.getContrasena());

        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);

        UsuarioResponseDto responseDto = new UsuarioResponseDto();
        responseDto.setId(usuarioGuardado.getId());
        responseDto.setNombre(usuarioGuardado.getNombre());
        responseDto.setCorreo(usuarioGuardado.getCorreo());

        return responseDto;
    }
    @Override
    public UsuarioResponseDto obtenerPorId(Long id) {
        // 1. Buscar en la base de datos
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // 2. Empacar en el DTO de respuesta (No devolvemos el password por seguridad)
        UsuarioResponseDto responseDto = new UsuarioResponseDto();
        responseDto.setId(usuario.getId());
        responseDto.setNombre(usuario.getNombre());
        responseDto.setCorreo(usuario.getCorreo());
        responseDto.setUnidad(usuario.getUnidad());

        return responseDto;
    }

    @Override
    public UsuarioResponseDto actualizar(Long id, UsuarioRequestDto requestDto) {
        // 1. Buscar el usuario existente
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));


        usuarioExistente.setNombre(requestDto.getNombre());
        usuarioExistente.setCorreo(requestDto.getCorreo());
        usuarioExistente.setUnidad(requestDto.getUnidad());
        usuarioExistente.setContrasena(requestDto.getContrasena());


        Usuario usuarioGuardado = usuarioRepository.save(usuarioExistente);


        UsuarioResponseDto responseDto = new UsuarioResponseDto();
        responseDto.setId(usuarioGuardado.getId());
        responseDto.setNombre(usuarioGuardado.getNombre());
        responseDto.setCorreo(usuarioGuardado.getCorreo());
        responseDto.setUnidad(usuarioGuardado.getUnidad());

        return responseDto;
    }

    @Override
    public void eliminar (Long id) {
        usuarioRepository.deleteById(id);
    }

}
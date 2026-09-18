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
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
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
    public Usuario actualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }
    @Override
    public void eliminar (Long id) {
        usuarioRepository.deleteById(id);
    }

}
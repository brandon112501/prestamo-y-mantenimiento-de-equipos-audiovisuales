package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Rol;
import com.audiovisuales.prestamo.Entity.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Usuario obtenerPorId(Long id);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    Usuario guardarUsuario(Usuario usuario);
}

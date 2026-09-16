package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Usuario guardarUsuario(Usuario usuario);
}

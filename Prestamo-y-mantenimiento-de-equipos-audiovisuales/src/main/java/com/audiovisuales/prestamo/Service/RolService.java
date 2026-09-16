package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Rol;
import java.util.List;

public interface RolService {
    List<Rol> listarTodos();
    Rol obtenerPorId(Long id);
    Rol crear(Rol rol);
    Rol actualizar(Long id, Rol rol);
    void eliminar(Long id);

    List<Rol> listarRoles();
}


package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Rol;
import java.util.List;

public interface RolService {
    List<Rol> listarRoles();
    Rol guardarRol(Rol rol);
}

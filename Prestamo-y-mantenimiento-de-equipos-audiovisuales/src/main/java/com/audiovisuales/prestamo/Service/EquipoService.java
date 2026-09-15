package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Equipo;
import java.util.List;

public interface EquipoService {
    List<Equipo> listarTodos();
    Equipo obtenerPorId(Long id);
    Equipo crear(Equipo equipo);
    Equipo actualizar(Long id, Equipo equipo);
    void eliminar(Long id);
}
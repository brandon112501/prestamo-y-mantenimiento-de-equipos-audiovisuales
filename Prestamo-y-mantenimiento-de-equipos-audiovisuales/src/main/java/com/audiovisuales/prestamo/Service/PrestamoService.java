package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Prestamo;
import com.audiovisuales.prestamo.Entity.Rol;

import java.util.List;

public interface PrestamoService {
    List<Prestamo> listarTodos();
    Prestamo obtenerPorId(Long id);
    Prestamo crear(Prestamo rol);
    Prestamo actualizar(Long id, Prestamo prestamo);
    void eliminar(Long id);
}
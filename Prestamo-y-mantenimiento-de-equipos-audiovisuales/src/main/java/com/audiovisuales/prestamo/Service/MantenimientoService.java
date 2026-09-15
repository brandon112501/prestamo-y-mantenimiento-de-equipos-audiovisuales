package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Mantenimiento;
import java.util.List;

public interface MantenimientoService {
    List<Mantenimiento> listarTodos();
    Mantenimiento obtenerPorId(Long id);
    Mantenimiento crear(Mantenimiento mantenimiento);
    Mantenimiento actualizar(Long id, Mantenimiento mantenimiento);
    void eliminar(Long id);
}
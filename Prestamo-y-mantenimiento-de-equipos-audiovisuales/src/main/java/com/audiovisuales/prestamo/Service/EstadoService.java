package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Estado;
import java.util.List;

public interface EstadoService {
    List<Estado> listarTodos();
    Estado obtenerPorId(Long id);
    Estado crear(Estado estado);
    Estado actualizar(Long id, Estado detalles);
    void eliminar(Long id);
}
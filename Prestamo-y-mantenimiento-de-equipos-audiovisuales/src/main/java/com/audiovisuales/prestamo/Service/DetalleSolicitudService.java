package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.DetalleSolicitud;
import java.util.List;

public interface DetalleSolicitudService {
    List<DetalleSolicitud> listarTodos();
    DetalleSolicitud obtenerPorId(Long id);
    DetalleSolicitud crear(DetalleSolicitud detalleSolicitud);
    DetalleSolicitud actualizar(Long id, DetalleSolicitud detalleSolicitud);
    void eliminar(Long id);
}
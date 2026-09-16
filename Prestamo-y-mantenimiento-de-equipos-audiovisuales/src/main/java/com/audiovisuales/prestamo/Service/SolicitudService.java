package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Rol;
import com.audiovisuales.prestamo.Entity.Solicitud;
import java.util.List;

public interface SolicitudService {
    List<Solicitud> listarSolicitudes();
    Solicitud obtenerPorId(Long id);
    Solicitud crear(Solicitud solicitud);
    Rol actualizar(Long id, Rol rol);
    Solicitud guardarSolicitud(Solicitud solicitud);
}
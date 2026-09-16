package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Solicitud;
import java.util.List;

public interface SolicitudService {
    List<Solicitud> listarSolicitudes();
    Solicitud guardarSolicitud(Solicitud solicitud);
}
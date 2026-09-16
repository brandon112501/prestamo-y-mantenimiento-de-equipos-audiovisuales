package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Prestamo;
import java.util.List;

public interface PrestamoService {
    List<Prestamo> listarPrestamos();
    Prestamo guardarPrestamo(Prestamo prestamo);
}
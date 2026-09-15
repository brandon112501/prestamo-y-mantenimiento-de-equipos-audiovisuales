package com.audiovisuales.prestamo.Service;

import com.audiovisuales.prestamo.Entity.Accesorio;
import java.util.List;

public interface AccesorioService {
    List<Accesorio> listarTodos();
    Accesorio obtenerPorId(Long id);
    Accesorio crear(Accesorio accesorio);
    Accesorio actualizar(Long id, Accesorio accesorio);
    void eliminar(Long id);
}
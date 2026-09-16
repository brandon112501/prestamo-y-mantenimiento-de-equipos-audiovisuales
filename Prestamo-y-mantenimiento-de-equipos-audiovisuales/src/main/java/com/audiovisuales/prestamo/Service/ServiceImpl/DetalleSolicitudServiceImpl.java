package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.DetalleSolicitud;
import com.audiovisuales.prestamo.Repository.DetalleSolicitudRepository;
import com.audiovisuales.prestamo.Service.DetalleSolicitudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleSolicitudServiceImpl implements DetalleSolicitudService {

    private final DetalleSolicitudRepository repository;

    public DetalleSolicitudServiceImpl(DetalleSolicitudRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleSolicitud> listarTodos() {
        return repository.findAll();
    }

    @Override
    public DetalleSolicitud obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de solicitud no encontrado con ID: " + id));
    }

    @Override
    public DetalleSolicitud crear(DetalleSolicitud detalleSolicitud) {
        return repository.save(detalleSolicitud);
    }

    @Override
    public DetalleSolicitud actualizar(Long id, DetalleSolicitud detalles) {
        DetalleSolicitud detalle = obtenerPorId(id);
        detalle.setCantidad(detalles.getCantidad());
        detalle.setSolicitud(detalles.getSolicitud());
        detalle.setEquipo(detalles.getEquipo());
        return repository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        DetalleSolicitud detalle = obtenerPorId(id);
        repository.delete(detalle);
    }
}

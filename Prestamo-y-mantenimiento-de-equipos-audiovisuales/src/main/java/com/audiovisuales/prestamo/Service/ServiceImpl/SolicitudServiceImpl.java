package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Solicitud;
import com.audiovisuales.prestamo.Repository.SolicitudRepository;
import com.audiovisuales.prestamo.Service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> listarTodos() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud obtenerPorId(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    @Override
    public Solicitud crear(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud actualizar(Long id, Solicitud solicitud) {
        solicitud.setId(id);
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void eliminar(Long id) {
        solicitudRepository.deleteById(id);
    }
}

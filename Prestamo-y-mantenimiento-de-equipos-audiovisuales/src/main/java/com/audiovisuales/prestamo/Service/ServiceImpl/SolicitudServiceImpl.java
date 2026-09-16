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
    public List<Solicitud> listarSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud guardarSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
}
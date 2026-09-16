package com.audiovisuales.prestamo.Configuration.Controller.Service;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Solicitud;
import com.audiovisuales.prestamo.Configuration.Controller.Repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public List<Solicitud> listarSolicitudes() {
        return solicitudRepository.findAll();
    }

    public Solicitud guardarSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
}
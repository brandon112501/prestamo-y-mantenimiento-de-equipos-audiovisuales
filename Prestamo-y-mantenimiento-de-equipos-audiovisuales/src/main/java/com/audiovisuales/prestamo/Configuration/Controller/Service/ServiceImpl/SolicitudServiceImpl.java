package com.audiovisuales.prestamo.Configuration.Controller.Service.ServiceImpl;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Solicitud;
import com.audiovisuales.prestamo.Configuration.Controller.Repository.SolicitudRepository;
import com.audiovisuales.prestamo.Configuration.Controller.Service.SolicitudService;
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

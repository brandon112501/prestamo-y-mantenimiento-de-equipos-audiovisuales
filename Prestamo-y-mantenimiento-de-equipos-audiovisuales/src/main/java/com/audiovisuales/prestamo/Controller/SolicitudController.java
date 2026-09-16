package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Entity.Solicitud;
import com.audiovisuales.prestamo.Service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudService.listarSolicitudes();
    }

    @PostMapping
    public Solicitud guardarSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudService.guardarSolicitud(solicitud);
    }
}
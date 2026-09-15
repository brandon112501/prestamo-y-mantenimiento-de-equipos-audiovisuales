package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Entity.DetalleSolicitud;
import com.audiovisuales.prestamo.Service.DetalleSolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-solicitud")
public class DetalleSolicitudController {

    private final DetalleSolicitudService service;

    public DetalleSolicitudController(DetalleSolicitudService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DetalleSolicitud>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleSolicitud> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<DetalleSolicitud> crear(@RequestBody DetalleSolicitud detalleSolicitud) {
        return new ResponseEntity<>(service.crear(detalleSolicitud), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleSolicitud> actualizar(@PathVariable Long id, @RequestBody DetalleSolicitud detalleSolicitud) {
        return ResponseEntity.ok(service.actualizar(id, detalleSolicitud));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
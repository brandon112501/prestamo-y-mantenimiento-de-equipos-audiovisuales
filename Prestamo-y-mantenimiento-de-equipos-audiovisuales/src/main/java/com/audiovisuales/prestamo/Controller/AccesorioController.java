package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Entity.Accesorio;
import com.audiovisuales.prestamo.Service.AccesorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accesorios")
public class AccesorioController {

    private final AccesorioService service;

    public AccesorioController(AccesorioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Accesorio>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accesorio> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Accesorio> crear(@RequestBody Accesorio accesorio) {
        return new ResponseEntity<>(service.crear(accesorio), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accesorio> actualizar(@PathVariable Long id, @RequestBody Accesorio accesorio) {
        return ResponseEntity.ok(service.actualizar(id, accesorio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
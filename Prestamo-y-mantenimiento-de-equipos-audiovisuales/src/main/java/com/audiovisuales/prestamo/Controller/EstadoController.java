package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Entity.Estado;
import com.audiovisuales.prestamo.Service.EstadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "*")
public class EstadoController {

    private final EstadoService service;

    public EstadoController(EstadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estado> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Estado obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Estado crear(@RequestBody Estado estado) {
        return service.crear(estado);
    }

    @PutMapping("/{id}")
    public Estado actualizar(@PathVariable Long id, @RequestBody Estado detalles) {
        return service.actualizar(id, detalles);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
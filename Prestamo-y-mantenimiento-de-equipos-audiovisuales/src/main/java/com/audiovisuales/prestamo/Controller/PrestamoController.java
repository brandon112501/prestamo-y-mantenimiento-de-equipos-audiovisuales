package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Entity.Prestamo;
import com.audiovisuales.prestamo.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.listarPrestamos();
    }

    @PostMapping
    public Prestamo guardarPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.guardarPrestamo(prestamo);
    }
}
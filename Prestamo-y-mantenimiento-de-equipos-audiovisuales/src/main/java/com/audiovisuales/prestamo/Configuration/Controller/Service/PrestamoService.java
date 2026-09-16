package com.audiovisuales.prestamo.Configuration.Controller.Service;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Prestamo;
import com.audiovisuales.prestamo.Configuration.Controller.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }
}
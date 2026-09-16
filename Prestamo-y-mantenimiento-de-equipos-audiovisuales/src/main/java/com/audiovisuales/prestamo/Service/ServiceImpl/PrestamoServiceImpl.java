package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Prestamo;
import com.audiovisuales.prestamo.Repository.PrestamoRepository;
import com.audiovisuales.prestamo.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo guardarPrestamo(Prestamo prestamo)

    {
        return prestamoRepository.save(prestamo);
    }
}
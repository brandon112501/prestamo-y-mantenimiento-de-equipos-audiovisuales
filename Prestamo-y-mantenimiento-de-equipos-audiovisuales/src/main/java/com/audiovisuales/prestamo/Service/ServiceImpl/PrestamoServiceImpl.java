package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Estado;
import com.audiovisuales.prestamo.Entity.Prestamo;
import com.audiovisuales.prestamo.Repository.PrestamoRepository;
import com.audiovisuales.prestamo.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return repository.findAll();
    }

    @Override
    public Prestamo guardarPrestamo(Prestamo prestamo)
    {
        return repository.save(prestamo);
    }

    @Override
    public void eliminar(Long id) {
        Estado estado = obtenerPorId(id);
        repository.delete(estado);
    }
}
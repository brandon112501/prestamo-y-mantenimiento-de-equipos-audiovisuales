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
    private  PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> listarTodos() {
        return prestamoRepository.findAll();
    }
    @Override
    public Prestamo obtenerPorId(Long id) {
        return prestamoRepository.findById(id).orElse(null);

    }
    @Override
    public Prestamo crear(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizar(Long id, Prestamo prestamo) {
        prestamo.setId(id);
        return prestamoRepository.save(prestamo);
    }


    @Override
    public void eliminar(Long id) {
        prestamoRepository.deleteById(id);
    }
}
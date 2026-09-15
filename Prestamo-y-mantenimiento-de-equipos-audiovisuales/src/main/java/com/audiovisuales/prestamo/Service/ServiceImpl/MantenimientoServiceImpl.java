package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Mantenimiento;
import com.audiovisuales.prestamo.Repository.MantenimientoRepository;
import com.audiovisuales.prestamo.Service.MantenimientoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {

    private final MantenimientoRepository repository;

    public MantenimientoServiceImpl(MantenimientoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Mantenimiento> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Mantenimiento obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado con ID: " + id));
    }

    @Override
    public Mantenimiento crear(Mantenimiento mantenimiento) {
        return repository.save(mantenimiento);
    }

    @Override
    public Mantenimiento actualizar(Long id, Mantenimiento detalles) {
        Mantenimiento mantenimiento = obtenerPorId(id);
        mantenimiento.setTipo(detalles.getTipo());
        mantenimiento.setFecha(detalles.getFecha());
        mantenimiento.setDiagnostico(detalles.getDiagnostico());
        mantenimiento.setCosto(detalles.getCosto());
        mantenimiento.setEquipo(detalles.getEquipo());
        mantenimiento.setEstado(detalles.getEstado());
        return repository.save(mantenimiento);
    }

    @Override
    public void eliminar(Long id) {
        Mantenimiento mantenimiento = obtenerPorId(id);
        repository.delete(mantenimiento);
    }
}
package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Estado;
import com.audiovisuales.prestamo.Repository.EstadoRepository;
import com.audiovisuales.prestamo.Service.EstadoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository repository;

    public EstadoServiceImpl(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estado> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Estado obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + id));
    }

    @Override
    public Estado crear(Estado estado) {
        return repository.save(estado);
    }

    @Override
    public Estado actualizar(Long id, Estado detalles) {
        Estado estado = obtenerPorId(id);
        estado.setNombreEstado(detalles.getNombreEstado());
        estado.setModulo(detalles.getModulo());
        return repository.save(estado);
    }

    @Override
    public void eliminar(Long id) {
        Estado estado = obtenerPorId(id);
        repository.delete(estado);
    }
}
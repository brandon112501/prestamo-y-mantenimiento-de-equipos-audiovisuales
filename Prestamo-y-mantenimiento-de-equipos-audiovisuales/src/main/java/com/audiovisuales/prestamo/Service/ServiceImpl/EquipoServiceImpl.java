package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Equipo;
import com.audiovisuales.prestamo.Repository.EquipoRepository;
import com.audiovisuales.prestamo.Service.EquipoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository repository;

    public EquipoServiceImpl(EquipoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Equipo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Equipo obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
    }

    @Override
    public Equipo crear(Equipo equipo) {
        return repository.save(equipo);
    }

    @Override
    public Equipo actualizar(Long id, Equipo detalles) {
        Equipo equipo = obtenerPorId(id);
        equipo.setCodigoInventario(detalles.getCodigoInventario());
        equipo.setTipo(detalles.getTipo());
        equipo.setMarca(detalles.getMarca());
        equipo.setModelo(detalles.getModelo());
        equipo.setUbicacion(detalles.getUbicacion());
        equipo.setEstado(detalles.getEstado());
        return repository.save(equipo);
    }

    @Override
    public void eliminar(Long id) {
        Equipo equipo = obtenerPorId(id);
        repository.delete(equipo);
    }
}
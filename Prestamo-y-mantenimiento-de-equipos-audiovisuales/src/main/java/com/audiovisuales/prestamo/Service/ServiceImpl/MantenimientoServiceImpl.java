package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.MantenimientoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.MantenimientoResponseDto;
import com.audiovisuales.prestamo.Entity.Equipo;
import com.audiovisuales.prestamo.Entity.Estado;
import com.audiovisuales.prestamo.Entity.Mantenimiento;
import com.audiovisuales.prestamo.Repository.EquipoRepository;
import com.audiovisuales.prestamo.Repository.EstadoRepository;
import com.audiovisuales.prestamo.Repository.MantenimientoRepository;
import com.audiovisuales.prestamo.Service.MantenimientoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final EquipoRepository equipoRepository;
    private final EstadoRepository estadoRepository;

    public MantenimientoServiceImpl(MantenimientoRepository mantenimientoRepository,
                                    EquipoRepository equipoRepository,
                                    EstadoRepository estadoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
        this.equipoRepository = equipoRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MantenimientoResponseDto> obtenerTodos() {
        return mantenimientoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MantenimientoResponseDto obtenerPorId(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado con ID: " + id));
        return mapToResponse(mantenimiento);
    }

    @Override
    @Transactional
    public MantenimientoResponseDto crear(MantenimientoRequestDto request) {
        Equipo equipo = equipoRepository.findById(request.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + request.getEquipoId()));

        Estado estado = estadoRepository.findById(request.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + request.getEstadoId()));

        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setTipo(request.getTipo());
        mantenimiento.setFecha(request.getFecha());
        mantenimiento.setDiagnostico(request.getDiagnostico());
        mantenimiento.setCosto(request.getCosto());
        mantenimiento.setEquipo(equipo);
        mantenimiento.setEstado(estado);

        Mantenimiento mantenimientoGuardado = mantenimientoRepository.save(mantenimiento);
        return mapToResponse(mantenimientoGuardado);
    }

    @Override
    @Transactional
    public MantenimientoResponseDto actualizar(Long id, MantenimientoRequestDto request) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado con ID: " + id));

        Equipo equipo = equipoRepository.findById(request.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + request.getEquipoId()));

        Estado estado = estadoRepository.findById(request.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + request.getEstadoId()));

        mantenimiento.setTipo(request.getTipo());
        mantenimiento.setFecha(request.getFecha());
        mantenimiento.setDiagnostico(request.getDiagnostico());
        mantenimiento.setCosto(request.getCosto());
        mantenimiento.setEquipo(equipo);
        mantenimiento.setEstado(estado);

        Mantenimiento mantenimientoActualizado = mantenimientoRepository.save(mantenimiento);
        return mapToResponse(mantenimientoActualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!mantenimientoRepository.existsById(id)) {
            throw new RuntimeException("Mantenimiento no encontrado con ID: " + id);
        }
        mantenimientoRepository.deleteById(id);
    }

    private MantenimientoResponseDto mapToResponse(Mantenimiento mantenimiento) {
        return new MantenimientoResponseDto(
                mantenimiento.getId(),
                mantenimiento.getTipo(),
                mantenimiento.getFecha(),
                mantenimiento.getDiagnostico(),
                mantenimiento.getCosto(),
                mantenimiento.getEquipo().getId(),
                mantenimiento.getEquipo().getCodigoInventario(),
                mantenimiento.getEstado().getId(),
                mantenimiento.getEstado().getNombreEstado()
        );
    }
}
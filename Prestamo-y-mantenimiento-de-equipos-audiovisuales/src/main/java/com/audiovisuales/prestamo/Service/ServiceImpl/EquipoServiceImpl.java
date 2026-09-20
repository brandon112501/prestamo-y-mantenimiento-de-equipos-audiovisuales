package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.EquipoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.EquipoResponseDto;
import com.audiovisuales.prestamo.Entity.Equipo;
import com.audiovisuales.prestamo.Entity.Estado;
import com.audiovisuales.prestamo.Repository.EquipoRepository;
import com.audiovisuales.prestamo.Repository.EstadoRepository;
import com.audiovisuales.prestamo.Service.EquipoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;
    private final EstadoRepository estadoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository, EstadoRepository estadoRepository) {
        this.equipoRepository = equipoRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipoResponseDto> obtenerTodos() {
        return equipoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EquipoResponseDto obtenerPorId(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
        return mapToResponse(equipo);
    }

    @Override
    @Transactional
    public EquipoResponseDto crear(EquipoRequestDto request) {
        Estado estado = estadoRepository.findById(request.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + request.getEstadoId()));

        Equipo equipo = new Equipo();
        equipo.setCodigoInventario(request.getCodigoInventario());
        equipo.setTipo(request.getTipo());
        equipo.setMarca(request.getMarca());
        equipo.setModelo(request.getModelo());
        equipo.setUbicacion(request.getUbicacion());
        equipo.setEstado(estado);

        Equipo equipoGuardado = equipoRepository.save(equipo);
        return mapToResponse(equipoGuardado);
    }

    @Override
    @Transactional
    public EquipoResponseDto actualizar(Long id, EquipoRequestDto request) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));

        Estado estado = estadoRepository.findById(request.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + request.getEstadoId()));

        equipo.setCodigoInventario(request.getCodigoInventario());
        equipo.setTipo(request.getTipo());
        equipo.setMarca(request.getMarca());
        equipo.setModelo(request.getModelo());
        equipo.setUbicacion(request.getUbicacion());
        equipo.setEstado(estado);

        Equipo equipoActualizado = equipoRepository.save(equipo);
        return mapToResponse(equipoActualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!equipoRepository.existsById(id)) {
            throw new RuntimeException("Equipo no encontrado con ID: " + id);
        }
        equipoRepository.deleteById(id);
    }

    private EquipoResponseDto mapToResponse(Equipo equipo) {
        return new EquipoResponseDto(
                equipo.getId(),
                equipo.getCodigoInventario(),
                equipo.getTipo(),
                equipo.getMarca(),
                equipo.getModelo(),
                equipo.getUbicacion(),
                equipo.getEstado().getId(),
                equipo.getEstado().getNombreEstado()
        );
    }
}
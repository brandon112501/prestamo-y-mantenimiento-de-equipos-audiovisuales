package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.EstadoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.EstadoResponseDto;
import com.audiovisuales.prestamo.Entity.Estado;
import com.audiovisuales.prestamo.Repository.EstadoRepository;
import com.audiovisuales.prestamo.Service.EstadoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstadoResponseDto> obtenerTodos() {
        return estadoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EstadoResponseDto obtenerPorId(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + id));
        return mapToResponse(estado);
    }

    @Override
    @Transactional
    public EstadoResponseDto crear(EstadoRequestDto request) {
        Estado estado = new Estado();
        estado.setNombreEstado(request.getNombreEstado());
        estado.setModulo(request.getModulo());

        Estado estadoGuardado = estadoRepository.save(estado);
        return mapToResponse(estadoGuardado);
    }

    @Override
    @Transactional
    public EstadoResponseDto actualizar(Long id, EstadoRequestDto request) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + id));

        estado.setNombreEstado(request.getNombreEstado());
        estado.setModulo(request.getModulo());

        Estado estadoActualizado = estadoRepository.save(estado);
        return mapToResponse(estadoActualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado con ID: " + id);
        }
        estadoRepository.deleteById(id);
    }

    private EstadoResponseDto mapToResponse(Estado estado) {
        return new EstadoResponseDto(
                estado.getId(),
                estado.getNombreEstado(),
                estado.getModulo()
        );
    }
}
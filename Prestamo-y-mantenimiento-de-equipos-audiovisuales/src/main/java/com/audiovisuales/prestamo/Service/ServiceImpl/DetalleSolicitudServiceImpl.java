package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.DetalleSolicitudRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.DetalleSolicitudResponseDto;
import com.audiovisuales.prestamo.Entity.DetalleSolicitud;
import com.audiovisuales.prestamo.Entity.Equipo;
import com.audiovisuales.prestamo.Entity.Solicitud;
import com.audiovisuales.prestamo.Repository.DetalleSolicitudRepository;
import com.audiovisuales.prestamo.Repository.EquipoRepository;
import com.audiovisuales.prestamo.Repository.SolicitudRepository;
import com.audiovisuales.prestamo.Service.DetalleSolicitudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleSolicitudServiceImpl implements DetalleSolicitudService {

    private final DetalleSolicitudRepository detalleSolicitudRepository;
    private final SolicitudRepository solicitudRepository;
    private final EquipoRepository equipoRepository;

    public DetalleSolicitudServiceImpl(DetalleSolicitudRepository detalleSolicitudRepository,
                                       SolicitudRepository solicitudRepository,
                                       EquipoRepository equipoRepository) {
        this.detalleSolicitudRepository = detalleSolicitudRepository;
        this.solicitudRepository = solicitudRepository;
        this.equipoRepository = equipoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleSolicitudResponseDto> obtenerTodos() {
        return detalleSolicitudRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleSolicitudResponseDto obtenerPorId(Long id) {
        DetalleSolicitud detalle = detalleSolicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de solicitud no encontrado con ID: " + id));
        return mapToResponse(detalle);
    }

    @Override
    @Transactional
    public DetalleSolicitudResponseDto crear(DetalleSolicitudRequestDto request) {
        Solicitud solicitud = solicitudRepository.findById(request.getSolicitudId())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + request.getSolicitudId()));

        Equipo equipo = equipoRepository.findById(request.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + request.getEquipoId()));

        DetalleSolicitud detalle = new DetalleSolicitud();
        detalle.setCantidad(request.getCantidad());
        detalle.setSolicitud(solicitud);
        detalle.setEquipo(equipo);

        DetalleSolicitud detalleGuardado = detalleSolicitudRepository.save(detalle);
        return mapToResponse(detalleGuardado);
    }

    @Override
    @Transactional
    public DetalleSolicitudResponseDto actualizar(Long id, DetalleSolicitudRequestDto request) {
        DetalleSolicitud detalle = detalleSolicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de solicitud no encontrado con ID: " + id));

        Solicitud solicitud = solicitudRepository.findById(request.getSolicitudId())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + request.getSolicitudId()));

        Equipo equipo = equipoRepository.findById(request.getEquipoId())
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + request.getEquipoId()));

        detalle.setCantidad(request.getCantidad());
        detalle.setSolicitud(solicitud);
        detalle.setEquipo(equipo);

        DetalleSolicitud detalleActualizado = detalleSolicitudRepository.save(detalle);
        return mapToResponse(detalleActualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!detalleSolicitudRepository.existsById(id)) {
            throw new RuntimeException("Detalle de solicitud no encontrado con ID: " + id);
        }
        detalleSolicitudRepository.deleteById(id);
    }

    private DetalleSolicitudResponseDto mapToResponse(DetalleSolicitud detalle) {
        return new DetalleSolicitudResponseDto(
                detalle.getId(),
                detalle.getCantidad(),
                detalle.getSolicitud().getId(),
                detalle.getEquipo().getId(),
                detalle.getEquipo().getCodigoInventario()
        );
    }
}
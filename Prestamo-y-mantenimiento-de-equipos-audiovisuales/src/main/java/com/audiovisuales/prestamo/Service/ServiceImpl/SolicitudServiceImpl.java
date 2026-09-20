package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.SolicitudRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.SolicitudResponseDto;
import com.audiovisuales.prestamo.Entity.Solicitud;
import com.audiovisuales.prestamo.Repository.SolicitudRepository;
import com.audiovisuales.prestamo.Service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> listarTodos() {
        return solicitudRepository.findAll();
    }

    @Override
    public SolicitudResponseDto obtenerPorId(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + id));

        SolicitudResponseDto responseDto = new SolicitudResponseDto();
        responseDto.setId(solicitud.getId());
        responseDto.setFechaInicio(solicitud.getFechaInicio());
        responseDto.setFechaFin(solicitud.getFechaFin());
        responseDto.setMotivo(solicitud.getMotivo());
        responseDto.setEstado(solicitud.getEstado());

        return responseDto;
    }

    @Override
    public SolicitudResponseDto crear(SolicitudRequestDto requestDto) {


        Solicitud nuevaSolicitud = new Solicitud();
        nuevaSolicitud.setFechaInicio(requestDto.getFechaInicio());
        nuevaSolicitud.setFechaFin(requestDto.getFechaFin());
        nuevaSolicitud.setMotivo(requestDto.getMotivo());
        nuevaSolicitud.setEstado("PENDIENTE");

        Solicitud solicitudGuardada = solicitudRepository.save(nuevaSolicitud);


        SolicitudResponseDto responseDto = new SolicitudResponseDto();
        responseDto.setId(solicitudGuardada.getId());
        responseDto.setFechaInicio(solicitudGuardada.getFechaInicio());
        responseDto.setFechaFin(solicitudGuardada.getFechaFin());
        responseDto.setMotivo(solicitudGuardada.getMotivo());
        responseDto.setEstado(solicitudGuardada.getEstado());

        return responseDto;
    }

    @Override
    public SolicitudResponseDto actualizar(Long id, SolicitudRequestDto requestDto) {
        Solicitud solicitudExistente = solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + id));

        solicitudExistente.setFechaInicio(requestDto.getFechaInicio());
        solicitudExistente.setFechaFin(requestDto.getFechaFin());
        solicitudExistente.setMotivo(requestDto.getMotivo());

        Solicitud solicitudGuardada = solicitudRepository.save(solicitudExistente);

        SolicitudResponseDto responseDto = new SolicitudResponseDto();
        responseDto.setId(solicitudGuardada.getId());
        responseDto.setFechaInicio(solicitudGuardada.getFechaInicio());
        responseDto.setFechaFin(solicitudGuardada.getFechaFin());
        responseDto.setMotivo(solicitudGuardada.getMotivo());

        return responseDto;
    }

    @Override
    public void eliminar(Long id) {
        solicitudRepository.deleteById(id);
    }
}

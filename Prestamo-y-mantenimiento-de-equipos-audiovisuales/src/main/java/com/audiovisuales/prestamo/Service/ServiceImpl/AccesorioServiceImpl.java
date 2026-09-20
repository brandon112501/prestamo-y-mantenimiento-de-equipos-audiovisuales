package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.AccesorioRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.AccesorioResponseDto;
import com.audiovisuales.prestamo.Entity.Accesorio;
import com.audiovisuales.prestamo.Entity.Equipo;
import com.audiovisuales.prestamo.Repository.AccesorioRepository;
import com.audiovisuales.prestamo.Repository.EquipoRepository;
import com.audiovisuales.prestamo.Service.AccesorioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccesorioServiceImpl implements AccesorioService {

    private final AccesorioRepository accesorioRepository;
    private final EquipoRepository equipoRepository;

    public AccesorioServiceImpl(AccesorioRepository accesorioRepository,
                                EquipoRepository equipoRepository) {
        this.accesorioRepository = accesorioRepository;
        this.equipoRepository = equipoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccesorioResponseDto> obtenerTodos() {
        return accesorioRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AccesorioResponseDto obtenerPorId(Long id) {
        Accesorio accesorio = accesorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accesorio no encontrado con ID: " + id));
        return mapToResponse(accesorio);
    }

    @Override
    @Transactional
    public AccesorioResponseDto crear(AccesorioRequestDto request) {
        Equipo equipo = equipoRepository.findById(request.getEquipoAsociadoId())
                .orElseThrow(() -> new RuntimeException("Equipo asociado no encontrado con ID: " + request.getEquipoAsociadoId()));

        Accesorio accesorio = new Accesorio();
        accesorio.setNombre(request.getNombre());
        accesorio.setCantidad(request.getCantidad());
        accesorio.setEquipoAsociado(equipo);

        Accesorio accesorioGuardado = accesorioRepository.save(accesorio);
        return mapToResponse(accesorioGuardado);
    }

    @Override
    @Transactional
    public AccesorioResponseDto actualizar(Long id, AccesorioRequestDto request) {
        Accesorio accesorio = accesorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accesorio no encontrado con ID: " + id));

        Equipo equipo = equipoRepository.findById(request.getEquipoAsociadoId())
                .orElseThrow(() -> new RuntimeException("Equipo asociado no encontrado con ID: " + request.getEquipoAsociadoId()));

        accesorio.setNombre(request.getNombre());
        accesorio.setCantidad(request.getCantidad());
        accesorio.setEquipoAsociado(equipo);

        Accesorio accesorioActualizado = accesorioRepository.save(accesorio);
        return mapToResponse(accesorioActualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!accesorioRepository.existsById(id)) {
            throw new RuntimeException("Accesorio no encontrado con ID: " + id);
        }
        accesorioRepository.deleteById(id);
    }

    private AccesorioResponseDto mapToResponse(Accesorio accesorio) {
        return new AccesorioResponseDto(
                accesorio.getId(),
                accesorio.getNombre(),
                accesorio.getCantidad(),
                accesorio.getEquipoAsociado().getId(),
                accesorio.getEquipoAsociado().getCodigoInventario()
        );
    }
}
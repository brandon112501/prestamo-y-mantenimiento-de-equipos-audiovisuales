package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.PrestamoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.PrestamoResponseDto;
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
    private PrestamoRepository prestamoRepository;


    @Override
    public List<Prestamo> listarTodos() {
        return prestamoRepository.findAll();
    }
    @Override
    public PrestamoResponseDto obtenerPorId(Long id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con ID: " + id));

        PrestamoResponseDto responseDto = new PrestamoResponseDto();
        responseDto.setId(prestamo.getId());
        responseDto.setFechaPrestamo(prestamo.getFechaEntrega());
        responseDto.setFechaDevolucion(prestamo.getFechaDevolucion());
        responseDto.setEstado(prestamo.getEstadoInicial());
        responseDto.setEstadoFinal(prestamo.getEstadoFinal());
        responseDto.setNovedades(prestamo.getNovedades());

        return responseDto;
    }

    @Override
    public PrestamoResponseDto crear(PrestamoRequestDto requestDto) {


        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setFechaEntrega(requestDto.getFechaPrestamo());
        nuevoPrestamo.setFechaDevolucion(requestDto.getFechaDevolucion());
        nuevoPrestamo.setEstadoInicial("ACTIVO");


        Prestamo prestamoGuardado = prestamoRepository.save(nuevoPrestamo);


        PrestamoResponseDto responseDto = new PrestamoResponseDto();
        responseDto.setId(prestamoGuardado.getId());
        responseDto.setFechaPrestamo(prestamoGuardado.getFechaEntrega());
        responseDto.setFechaDevolucion(prestamoGuardado.getFechaDevolucion());
        responseDto.setEstado(prestamoGuardado.getEstadoInicial());

        return responseDto;
    }



    @Override
    public PrestamoResponseDto actualizar(Long id, PrestamoRequestDto requestDto) {
        Prestamo prestamoExistente = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con ID: " + id));

        prestamoExistente.setFechaEntrega(requestDto.getFechaPrestamo());
        prestamoExistente.setFechaDevolucion(requestDto.getFechaDevolucion());
        prestamoExistente.setEstadoFinal(requestDto.getEstadoFinal());
        prestamoExistente.setNovedades(requestDto.getNovedades());

        Prestamo prestamoGuardado = prestamoRepository.save(prestamoExistente);

        PrestamoResponseDto responseDto = new PrestamoResponseDto();
        responseDto.setId(prestamoGuardado.getId());
        responseDto.setFechaPrestamo(prestamoGuardado.getFechaEntrega());
        responseDto.setFechaDevolucion(prestamoGuardado.getFechaDevolucion());
        responseDto.setEstado(prestamoGuardado.getEstadoInicial());

        return responseDto;
    }


    @Override
    public void eliminar(Long id) {
        prestamoRepository.deleteById(id);
    }
}
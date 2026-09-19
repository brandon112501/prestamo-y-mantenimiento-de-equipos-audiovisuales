package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.PrestamoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.PrestamoResponseDto;
import com.audiovisuales.prestamo.Entity.Prestamo;
import com.audiovisuales.prestamo.Service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<PrestamoResponseDto> crearPrestamo(@Valid @RequestBody PrestamoRequestDto requestDto) {
        PrestamoResponseDto nuevoPrestamo = prestamoService.crear(requestDto);
        return new ResponseEntity<>(nuevoPrestamo, HttpStatus.CREATED);
    }

}
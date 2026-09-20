package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.EstadoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.EstadoResponseDto;
import com.audiovisuales.prestamo.Service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(estadoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<EstadoResponseDto> crear(@Valid @RequestBody EstadoRequestDto request) {
        return new ResponseEntity<>(estadoService.crear(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody EstadoRequestDto request) {
        return ResponseEntity.ok(estadoService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
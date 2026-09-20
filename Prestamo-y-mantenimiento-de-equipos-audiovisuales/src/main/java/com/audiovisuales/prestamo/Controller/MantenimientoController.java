package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.MantenimientoRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.MantenimientoResponseDto;
import com.audiovisuales.prestamo.Service.MantenimientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    @GetMapping
    public ResponseEntity<List<MantenimientoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(mantenimientoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mantenimientoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<MantenimientoResponseDto> crear(@Valid @RequestBody MantenimientoRequestDto request) {
        return new ResponseEntity<>(mantenimientoService.crear(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody MantenimientoRequestDto request) {
        return ResponseEntity.ok(mantenimientoService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mantenimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
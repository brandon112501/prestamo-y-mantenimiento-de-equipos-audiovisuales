package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.AccesorioRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.AccesorioResponseDto;
import com.audiovisuales.prestamo.Service.AccesorioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accesorios")
public class AccesorioController {

    private final AccesorioService accesorioService;

    public AccesorioController(AccesorioService accesorioService) {
        this.accesorioService = accesorioService;
    }

    @GetMapping
    public ResponseEntity<List<AccesorioResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(accesorioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccesorioResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(accesorioService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<AccesorioResponseDto> crear(@Valid @RequestBody AccesorioRequestDto request) {
        return new ResponseEntity<>(accesorioService.crear(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccesorioResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody AccesorioRequestDto request) {
        return ResponseEntity.ok(accesorioService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        accesorioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
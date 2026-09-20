package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.DetalleSolicitudRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.DetalleSolicitudResponseDto;
import com.audiovisuales.prestamo.Service.DetalleSolicitudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-solicitud")
public class DetalleSolicitudController {

    private final DetalleSolicitudService detalleSolicitudService;

    public DetalleSolicitudController(DetalleSolicitudService detalleSolicitudService) {
        this.detalleSolicitudService = detalleSolicitudService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleSolicitudResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(detalleSolicitudService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleSolicitudResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detalleSolicitudService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<DetalleSolicitudResponseDto> crear(@Valid @RequestBody DetalleSolicitudRequestDto request) {
        return new ResponseEntity<>(detalleSolicitudService.crear(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleSolicitudResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody DetalleSolicitudRequestDto request) {
        return ResponseEntity.ok(detalleSolicitudService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleSolicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
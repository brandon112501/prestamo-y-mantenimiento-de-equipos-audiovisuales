package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.SolicitudRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.SolicitudResponseDto;
import com.audiovisuales.prestamo.Entity.Solicitud;
import com.audiovisuales.prestamo.Service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<SolicitudResponseDto> crearSolicitud(@Valid @RequestBody SolicitudRequestDto requestDto) {
        SolicitudResponseDto nuevaSolicitud = solicitudService.crear(requestDto);
        return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudResponseDto> actualizar(@PathVariable Long id, @Valid @RequestBody SolicitudRequestDto requestDto) {
        return ResponseEntity.ok(solicitudService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
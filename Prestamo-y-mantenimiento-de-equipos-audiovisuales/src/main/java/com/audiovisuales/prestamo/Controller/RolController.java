package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.RolRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.RolResponseDto;
import com.audiovisuales.prestamo.Entity.Rol;
import com.audiovisuales.prestamo.Service.RolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.listarTodos();
    }
    @PostMapping
    public ResponseEntity<RolResponseDto> crearRol(@Valid @RequestBody RolRequestDto requestDto) {
        RolResponseDto nuevoRol = rolService.crear(requestDto);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }


}

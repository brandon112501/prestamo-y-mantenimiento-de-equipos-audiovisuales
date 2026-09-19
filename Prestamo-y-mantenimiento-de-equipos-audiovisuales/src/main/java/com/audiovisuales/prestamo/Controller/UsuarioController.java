package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Dto.RequestDto.UsuarioRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.UsuarioResponseDto;
import com.audiovisuales.prestamo.Entity.Usuario;
import com.audiovisuales.prestamo.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodos();
    }
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> crearUsuario(@Valid @RequestBody UsuarioRequestDto requestDto) {
        UsuarioResponseDto nuevoUsuario = usuarioService.crear(requestDto);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> obtenerPorId(@PathVariable Long id) {
        UsuarioResponseDto usuario = usuarioService.obtenerPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDto requestDto) {
        UsuarioResponseDto usuarioActualizado = usuarioService.actualizar(id, requestDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
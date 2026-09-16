package com.audiovisuales.prestamo.Controller;

import com.audiovisuales.prestamo.Entity.Rol;
import com.audiovisuales.prestamo.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.listarRoles();
    }

    @PostMapping
    public Rol guardarRol(@RequestBody Rol rol) {
        return rolService.guardarRol(rol);
    }
}

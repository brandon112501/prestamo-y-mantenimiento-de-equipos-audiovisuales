package com.audiovisuales.prestamo.Configuration.Controller.Service;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Rol;
import com.audiovisuales.prestamo.Configuration.Controller.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }
}
package com.audiovisuales.prestamo.Configuration.Controller.Service.ServiceImpl;

import com.audiovisuales.prestamo.Configuration.Controller.Entity.Rol;
import com.audiovisuales.prestamo.Configuration.Controller.Repository.RolRepository;
import com.audiovisuales.prestamo.Configuration.Controller.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }
}

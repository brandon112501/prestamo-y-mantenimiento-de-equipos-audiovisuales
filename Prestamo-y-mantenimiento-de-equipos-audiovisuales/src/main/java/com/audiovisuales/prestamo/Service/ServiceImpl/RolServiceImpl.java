package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Entity.Rol;
import com.audiovisuales.prestamo.Repository.RolRepository;
import com.audiovisuales.prestamo.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class RolServiceImpl implements RolService {

        @Autowired
        private RolRepository rolRepository;

        @Override
        public List<Rol> listarTodos() {
            return rolRepository.findAll();
        }

        @Override
        public Rol obtenerPorId(Long id) {

            return rolRepository.findById(id).orElse(null);
        }

        @Override
        public Rol crear(Rol rol) {
            return rolRepository.save(rol);
        }

        @Override
        public Rol actualizar(Long id, Rol rol) {

            rol.setId(id);
            return rolRepository.save(rol);
        }

        @Override
        public void eliminar(Long id) {
            rolRepository.deleteById(id);
        }

    }

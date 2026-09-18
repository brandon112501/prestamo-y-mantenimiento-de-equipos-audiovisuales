package com.audiovisuales.prestamo.Service.ServiceImpl;

import com.audiovisuales.prestamo.Dto.RequestDto.RolRequestDto;
import com.audiovisuales.prestamo.Dto.ResponseDto.RolResponseDto;
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
        public RolResponseDto crear(RolRequestDto requestDto) {

            Rol nuevoRol = new Rol();
            nuevoRol.setNombreRol(requestDto.getNombre());



            Rol rolGuardado = rolRepository.save(nuevoRol);


            RolResponseDto responseDto = new RolResponseDto();
            responseDto.setId(rolGuardado.getId());
            responseDto.setNombre(rolGuardado.getNombreRol());

            return responseDto;
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

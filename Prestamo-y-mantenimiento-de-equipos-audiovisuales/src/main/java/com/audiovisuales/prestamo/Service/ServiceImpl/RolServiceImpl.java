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
        public RolResponseDto crear(RolRequestDto requestDto) {

            Rol nuevoRol = new Rol();
            nuevoRol.setNombreRol(requestDto.getNombreRol());



            Rol rolGuardado = rolRepository.save(nuevoRol);


            RolResponseDto responseDto = new RolResponseDto();
            responseDto.setId(rolGuardado.getId());
            responseDto.setNombreRol(rolGuardado.getNombreRol());

            return responseDto;
        }

        @Override
        public RolResponseDto obtenerPorId(Long id) {
            Rol rol = rolRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));

            RolResponseDto responseDto = new RolResponseDto();
            responseDto.setId(rol.getId());
            responseDto.setNombreRol(rol.getNombreRol());
            responseDto.setDescripcion(rol.getDescripcion());

            return responseDto;
        }

        @Override
        public RolResponseDto actualizar(Long id, RolRequestDto requestDto) {
            Rol rolExistente = rolRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));

            rolExistente.setNombreRol(requestDto.getNombreRol());
            rolExistente.setDescripcion(requestDto.getDescripcion());

            Rol rolGuardado = rolRepository.save(rolExistente);

            RolResponseDto responseDto = new RolResponseDto();
            responseDto.setId(rolGuardado.getId());
            responseDto.setNombreRol(rolGuardado.getNombreRol());
            responseDto.setDescripcion(rolGuardado.getDescripcion());

            return responseDto;
        }

        @Override
        public void eliminar(Long id) {
            rolRepository.deleteById(id);
        }

    }

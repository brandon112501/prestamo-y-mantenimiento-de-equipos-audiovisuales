package com.audiovisuales.prestamo.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String correo;
    private String unidad;
    private Long rolId;
    private String nombreRol;

}

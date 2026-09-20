package com.audiovisuales.prestamo.Dto.ResponseDto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolResponseDto {

    private Long id;
    private String nombreRol;
    private String descripcion;

}
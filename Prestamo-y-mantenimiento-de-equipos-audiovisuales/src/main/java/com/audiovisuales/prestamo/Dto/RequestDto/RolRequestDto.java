package com.audiovisuales.prestamo.Dto.RequestDto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolRequestDto {

    @NotBlank(message = "El nombre del rol es obligatorio")
    private String nombre;

}
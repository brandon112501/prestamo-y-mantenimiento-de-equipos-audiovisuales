package com.audiovisuales.prestamo.Dto.RequestDto;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PrestamoRequestDto {

    @NotNull(message = "La fecha de préstamo es obligatoria")
    @FutureOrPresent(message = "La fecha de préstamo no puede ser en el pasado")
    private LocalDateTime fechaPrestamo;

    @NotNull(message = "La fecha de devolución esperada es obligatoria")
    @FutureOrPresent(message = "La fecha de devolución no puede ser en el pasado")
    private LocalDateTime fechaDevolucion;

    private String observaciones;
}
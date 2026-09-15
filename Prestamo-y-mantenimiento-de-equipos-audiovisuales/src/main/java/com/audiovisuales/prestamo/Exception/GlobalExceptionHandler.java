package com.audiovisuales.prestamo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de reglas de negocio Ej: "Un equipo ya está prestado"
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> manejarErroresDelNegocio(IllegalArgumentException ex) {

        // Creamos un diccionario (Map) para que la respuesta se vea como un JSON
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());

        // Devolvemos el mensaje con un código 400 (Que significa "Petición incorrecta")
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    // Manejo de errores genéricos para que la aplicación nunca se caiga
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> manejarErroresInesperados(Exception ex) {

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Ocurrió un error inesperado en el servidor.");

        // Devolvemos el mensaje con un código 500 Error interno
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
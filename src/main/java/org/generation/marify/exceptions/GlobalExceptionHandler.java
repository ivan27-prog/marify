package org.generation.marify.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

// Indica que esta clase actúa como un interceptor global de excepciones para los controladores REST
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Define que este metodo manejará específicamente las excepciones de tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFound(ResourceNotFoundException ex){

        // Crea una instancia de ProblemDetail con el código HTTP 404 y el mensaje original de la excepción
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

        // Asigna un título legible al detalle del problema
        problem.setTitle("Recurso no encontrado");

        // Define un URI de referencia para documentar el tipo de error
        problem.setType(URI.create("http://localhost:8080/errors/not-found"));

        // Añade una propiedad personalizada con la marca de tiempo exacta del error
        problem.setProperty("timestamp", Instant.now());

        // Retorna la estructura de error estandarizada (RFC 7807)
        return problem;
    }
}

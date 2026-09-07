package com.senac.bibliotech.exceptions;


import com.senac.bibliotech.exceptions.customexceptions.BibliotecaNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(BibliotecaNotFound.class)
    public ResponseEntity<StandardError> BibliotecaNotFound(BibliotecaNotFound e, HttpServletRequest request){

        String error = "Biblioteca not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}

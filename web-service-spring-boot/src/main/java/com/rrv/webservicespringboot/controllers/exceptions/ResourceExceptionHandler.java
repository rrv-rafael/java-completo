package com.rrv.webservicespringboot.controllers.exceptions;

import com.rrv.webservicespringboot.services.exceptions.DataBaseException;
import com.rrv.webservicespringboot.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest) {
        String error = "Recurso não encontrado.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, resourceNotFoundException.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> resourceNotFound(DataBaseException dataBaseException, HttpServletRequest httpServletRequest) {
        String error = "Erro de banco de dados.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, dataBaseException.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }
}

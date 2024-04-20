package com.rrv.webservicemongodb.controllers;

import com.rrv.webservicemongodb.domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {
        Usuario maria = new Usuario(1L, "Maria Silva", "maria@gmail.com");
        Usuario alex = new Usuario(2L, "Alexa Green", "alex@gmail.com");

        List<Usuario> usuarios = new ArrayList<>(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(usuarios);
    }
}

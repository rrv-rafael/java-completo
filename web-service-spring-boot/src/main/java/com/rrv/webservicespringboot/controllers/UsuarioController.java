package com.rrv.webservicespringboot.controllers;

import com.rrv.webservicespringboot.entidades.Usuario;
import com.rrv.webservicespringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();

        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/{codUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable Long codUsuario) {
        Usuario usuario = usuarioService.findById(codUsuario);

        return ResponseEntity.ok().body(usuario);
    }
}

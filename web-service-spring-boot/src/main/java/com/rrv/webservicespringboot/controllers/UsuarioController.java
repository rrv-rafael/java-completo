package com.rrv.webservicespringboot.controllers;

import com.rrv.webservicespringboot.entidades.Usuario;
import com.rrv.webservicespringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
        usuario = usuarioService.insert(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codUsuario}").buildAndExpand(usuario.getCodUsuario()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

    @DeleteMapping(value = "/{codUsuario}")
    public ResponseEntity<Void> delete(@PathVariable Long codUsuario) {
        usuarioService.delete(codUsuario);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{codUsuario}")
    public ResponseEntity<Usuario> update(@PathVariable Long codUsuario, @RequestBody Usuario usuario) {
        usuario = usuarioService.update(codUsuario, usuario);

        return ResponseEntity.ok().body(usuario);
    }
}

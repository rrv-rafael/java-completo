package com.rrv.webservicemongodb.controllers;

import com.rrv.webservicemongodb.domain.Post;
import com.rrv.webservicemongodb.domain.Usuario;
import com.rrv.webservicemongodb.dto.UsuarioDTO;
import com.rrv.webservicemongodb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::new).toList();

        return ResponseEntity.ok().body(usuariosDTO);
    }

    @GetMapping(value = "/{codUsuario}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String codUsuario) {
        Usuario usuario = usuarioService.findById(codUsuario);

        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> insert(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        usuario = usuarioService.insert(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codUsuario}").buildAndExpand(usuario.getCodUsuario()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{codUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String codUsuario) {
        usuarioService.deleteById(codUsuario);
    }

    @PutMapping(value = "/{codUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UsuarioDTO usuarioDTO, @PathVariable String codUsuario) {
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        usuario.setCodUsuario(codUsuario);
        usuarioService.update(usuario);
    }

    @GetMapping(value = "/{codUsuario}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String codUsuario) {
        Usuario usuario = usuarioService.findById(codUsuario);

        return ResponseEntity.ok().body(usuario.getPosts());
    }
}

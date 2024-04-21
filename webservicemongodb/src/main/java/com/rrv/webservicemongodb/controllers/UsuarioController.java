package com.rrv.webservicemongodb.controllers;

import com.rrv.webservicemongodb.domain.Usuario;
import com.rrv.webservicemongodb.dto.UsuarioDTO;
import com.rrv.webservicemongodb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::new).toList();

        return ResponseEntity.ok().body(usuariosDTO);
    }
}

package com.rrv.webservicespringboot.controllers;

import com.rrv.webservicespringboot.entidades.Categoria;
import com.rrv.webservicespringboot.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = categoriaService.findAll();

        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping(value = "/{codCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable Long codCategoria) {
        Categoria categoria = categoriaService.findById(codCategoria);

        return ResponseEntity.ok().body(categoria);
    }
}

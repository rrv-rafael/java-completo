package com.rrv.webservicespringboot.controllers;

import com.rrv.webservicespringboot.entidades.Produto;
import com.rrv.webservicespringboot.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoService.findAll();

        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping(value = "/{codProduto}")
    public ResponseEntity<Produto> findById(@PathVariable Long codProduto) {
        Produto produto = produtoService.findById(codProduto);

        return ResponseEntity.ok().body(produto);
    }
}

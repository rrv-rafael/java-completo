package com.rrv.webservicespringboot.services;

import com.rrv.webservicespringboot.entidades.Produto;
import com.rrv.webservicespringboot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long codProduto) {
        Optional<Produto> optionalProduto = produtoRepository.findById(codProduto);

        return optionalProduto.orElse(null);
    }
}

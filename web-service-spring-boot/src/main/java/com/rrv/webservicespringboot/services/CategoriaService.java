package com.rrv.webservicespringboot.services;

import com.rrv.webservicespringboot.entidades.Categoria;
import com.rrv.webservicespringboot.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long codCategoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(codCategoria);

        return optionalCategoria.orElse(null);
    }
}

package com.rrv.webservicespringboot.services;

import com.rrv.webservicespringboot.entidades.Categoria;
import com.rrv.webservicespringboot.repositories.CategoriaRepository;
import com.rrv.webservicespringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

        return optionalCategoria.orElseThrow(() -> new ResourceNotFoundException(codCategoria));
    }
}

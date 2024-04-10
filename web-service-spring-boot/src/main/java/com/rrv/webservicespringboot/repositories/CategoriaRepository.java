package com.rrv.webservicespringboot.repositories;

import com.rrv.webservicespringboot.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

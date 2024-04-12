package com.rrv.webservicespringboot.repositories;

import com.rrv.webservicespringboot.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

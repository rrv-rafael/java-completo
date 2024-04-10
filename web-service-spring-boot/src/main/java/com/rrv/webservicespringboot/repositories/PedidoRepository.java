package com.rrv.webservicespringboot.repositories;

import com.rrv.webservicespringboot.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

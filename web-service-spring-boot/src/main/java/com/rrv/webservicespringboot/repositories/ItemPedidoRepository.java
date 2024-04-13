package com.rrv.webservicespringboot.repositories;

import com.rrv.webservicespringboot.entidades.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}

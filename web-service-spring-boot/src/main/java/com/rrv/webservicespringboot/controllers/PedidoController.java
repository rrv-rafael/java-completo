package com.rrv.webservicespringboot.controllers;

import com.rrv.webservicespringboot.entidades.Pedido;
import com.rrv.webservicespringboot.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = pedidoService.findAll();

        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping(value = "/{codPedido}")
    public ResponseEntity<Pedido> findById(@PathVariable Long codPedido) {
        Pedido pedido = pedidoService.findById(codPedido);

        return ResponseEntity.ok().body(pedido);
    }
}

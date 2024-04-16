package com.rrv.webservicespringboot.services;

import com.rrv.webservicespringboot.entidades.Pedido;
import com.rrv.webservicespringboot.repositories.PedidoRepository;
import com.rrv.webservicespringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long codPedido) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(codPedido);

        return optionalPedido.orElseThrow(() -> new ResourceNotFoundException(codPedido));
    }
}

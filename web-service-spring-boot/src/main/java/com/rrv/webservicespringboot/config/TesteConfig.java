package com.rrv.webservicespringboot.config;

import com.rrv.webservicespringboot.entidades.Pedido;
import com.rrv.webservicespringboot.entidades.Usuario;
import com.rrv.webservicespringboot.entidades.enums.PedidoStatus;
import com.rrv.webservicespringboot.repositories.PedidoRepository;
import com.rrv.webservicespringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido pedido1 = new Pedido(null, Instant.parse("2029-06-20T19:53:07Z"), PedidoStatus.PAGO, usuario1);
        Pedido pedido2 = new Pedido(null, Instant.parse("2029-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario2);
        Pedido pedido3 = new Pedido(null, Instant.parse("2029-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario1);

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
    }
}
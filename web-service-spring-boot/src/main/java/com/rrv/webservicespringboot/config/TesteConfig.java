package com.rrv.webservicespringboot.config;

import com.rrv.webservicespringboot.entidades.Categoria;
import com.rrv.webservicespringboot.entidades.Pedido;
import com.rrv.webservicespringboot.entidades.Usuario;
import com.rrv.webservicespringboot.entidades.enums.PedidoStatus;
import com.rrv.webservicespringboot.repositories.CategoriaRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria categoria1 = new Categoria(null, "Eletrônicos");
        Categoria categoria2 = new Categoria(null, "Livros");
        Categoria categoria3 = new Categoria(null, "Computadores");

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));

        Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido pedido1 = new Pedido(null, Instant.parse("2029-06-20T19:53:07Z"), PedidoStatus.PAGO, usuario1);
        Pedido pedido2 = new Pedido(null, Instant.parse("2029-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario2);
        Pedido pedido3 = new Pedido(null, Instant.parse("2029-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario1);

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
    }
}
package com.rrv.webservicemongodb.config;

import com.rrv.webservicemongodb.domain.Post;
import com.rrv.webservicemongodb.domain.Usuario;
import com.rrv.webservicemongodb.dto.AutorDTO;
import com.rrv.webservicemongodb.repository.PostRepository;
import com.rrv.webservicemongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.deleteAll();
        postRepository.deleteAll();

        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", dateTimeFormatter), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("18/03/2018", dateTimeFormatter), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        usuarioRepository.save(maria);
    }
}

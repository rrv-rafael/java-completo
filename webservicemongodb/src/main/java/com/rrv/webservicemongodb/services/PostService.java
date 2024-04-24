package com.rrv.webservicemongodb.services;

import com.rrv.webservicemongodb.domain.Post;
import com.rrv.webservicemongodb.repository.PostRepository;
import com.rrv.webservicemongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String codPost) {
        return postRepository.findById(codPost).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
    }

    public List<Post> findByTitulo(String texto) {
        return postRepository.findByTitulo(texto);
    }

    public List<Post> fullSearch(String texto, LocalDate dataMin, LocalDate dataMax) {
        LocalDateTime midnight = dataMax.atTime(LocalTime.MAX);
        dataMax = midnight.toLocalDate();

        return postRepository.fullSearch(texto, dataMin, dataMax);
    }
}

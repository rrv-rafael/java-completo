package com.rrv.webservicemongodb.controllers;

import com.rrv.webservicemongodb.controllers.util.URL;
import com.rrv.webservicemongodb.domain.Post;
import com.rrv.webservicemongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/{codPost}")
    public ResponseEntity<Post> findById(@PathVariable String codPost) {
        Post post = postService.findById(codPost);

        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/buscartitulos")
    public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {
        texto = URL.decodeParam(texto);
        List<Post> posts = postService.findByTitulo(texto);

        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "texto", defaultValue = "") String texto,
            @RequestParam(value = "dataMin", defaultValue = "") String dataMin,
            @RequestParam(value = "dataMax", defaultValue = "") String dataMax) {
        texto = URL.decodeParam(texto);
        LocalDate min = URL.convertData(dataMin, LocalDate.EPOCH);
        LocalDate max = URL.convertData(dataMax, LocalDate.now());

        List<Post> posts = postService.fullSearch(texto, min, max);

        return ResponseEntity.ok().body(posts);
    }
}

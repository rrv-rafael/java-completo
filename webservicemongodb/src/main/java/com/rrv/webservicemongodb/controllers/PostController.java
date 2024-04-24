package com.rrv.webservicemongodb.controllers;

import com.rrv.webservicemongodb.controllers.util.URL;
import com.rrv.webservicemongodb.domain.Post;
import com.rrv.webservicemongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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
}

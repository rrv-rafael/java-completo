package com.rrv.webservicemongodb.controllers;

import com.rrv.webservicemongodb.domain.Post;
import com.rrv.webservicemongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

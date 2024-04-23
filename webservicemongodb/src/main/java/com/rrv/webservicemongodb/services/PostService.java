package com.rrv.webservicemongodb.services;

import com.rrv.webservicemongodb.domain.Post;
import com.rrv.webservicemongodb.repository.PostRepository;
import com.rrv.webservicemongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String codPost) {
        return postRepository.findById(codPost).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
    }
}

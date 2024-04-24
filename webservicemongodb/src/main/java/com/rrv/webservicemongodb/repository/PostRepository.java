package com.rrv.webservicemongodb.repository;

import com.rrv.webservicemongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTituloContainingIgnoreCase(String texto);
}

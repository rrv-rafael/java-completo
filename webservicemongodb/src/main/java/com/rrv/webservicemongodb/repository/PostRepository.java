package com.rrv.webservicemongodb.repository;

import com.rrv.webservicemongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitulo(String texto);
    List<Post> findByTituloContainingIgnoreCase(String texto);
}

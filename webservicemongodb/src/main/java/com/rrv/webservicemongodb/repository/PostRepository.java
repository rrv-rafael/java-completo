package com.rrv.webservicemongodb.repository;

import com.rrv.webservicemongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}

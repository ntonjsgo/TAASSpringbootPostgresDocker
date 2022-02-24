package com.javasampleapproach.springrest.postgresql.repo;

import java.util.List;

import com.javasampleapproach.springrest.postgresql.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByCustomerId(Long customer_id);
}

package com.javasampleapproach.springrest.postgresql.repo;

import java.util.List;

import com.javasampleapproach.springrest.postgresql.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByPostId(Long post_id);
}

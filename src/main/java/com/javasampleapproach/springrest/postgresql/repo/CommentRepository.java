package com.javasampleapproach.springrest.postgresql.repo;

import com.javasampleapproach.springrest.postgresql.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}

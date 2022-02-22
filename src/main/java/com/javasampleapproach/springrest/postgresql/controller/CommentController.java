package com.javasampleapproach.springrest.postgresql.controller;

import java.util.List;
import java.util.Optional;

import com.javasampleapproach.springrest.postgresql.model.*;
import com.javasampleapproach.springrest.postgresql.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentRepository repository;

    @Autowired
    PostRepository post_repository;

    @Autowired
    CustomerRepository customer_repository;

    @PostMapping(value = "/comments")
    public ResponseEntity<Comment> createComment(@RequestBody CreateCommentRequest requestBody) {
        Optional<Customer> _cust = customer_repository.findById(requestBody.customer_id);
        Optional<Post> _post = post_repository.findById(requestBody.post_id);
        if(_cust.isPresent() && _post.isPresent()) {
            return new ResponseEntity<>(repository.save(new Comment(requestBody.body, _post.get(), _cust.get())), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/comments/ofPost/{post_id}")
	public List<Comment> findByPostID(@PathVariable Long post_id) {
		List<Comment> comments_list = repository.findByPostId(post_id);
		return comments_list;
	}
}

package com.javasampleapproach.springrest.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javasampleapproach.springrest.postgresql.model.*;
import com.javasampleapproach.springrest.postgresql.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostRepository repository;

    @Autowired
    CustomerRepository customer_repository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {

        System.out.println("Get all Posts...");

        List<Post> posts = new ArrayList<>();
        repository.findAll().forEach(posts::add);

        return posts;
    }

	@GetMapping(value = "posts/{id}")
	public Post findById(@PathVariable Long id) {

		Post post = repository.findById(id).get();
		return post;
	}

	@GetMapping(value = "posts/ofCustomer/{customer_id}")
	public List<Post> findPostsByCustomerId(@PathVariable Long customer_id) {

		List<Post> posts = repository.findByCustomerId(customer_id);
		return posts;
	}

    @PostMapping("/posts")
	public Post createPost(@RequestBody CreatePostRequest postRequest) {
        System.out.println("Create Post...");
        Customer _cust = customer_repository.findById(postRequest.customer_id).get();
		Post _post = repository.save(new Post(postRequest.title, postRequest.body, _cust));
		return _post;
	}

    @PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
		System.out.println("Update Post with ID = " + id + "...");

		Optional<Post> postData = repository.findById(id);

		if (postData.isPresent()) {
			Post _post = postData.get();
			_post.setTitle(post.getTitle());
			_post.setBody(post.getBody());
			return new ResponseEntity<>(repository.save(_post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePost(@PathVariable("id") long id) {
		System.out.println("Delete Post with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Post has been deleted!", HttpStatus.OK);
	}
}

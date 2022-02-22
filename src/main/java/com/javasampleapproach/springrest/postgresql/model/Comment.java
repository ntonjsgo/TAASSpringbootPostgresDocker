package com.javasampleapproach.springrest.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade=CascadeType.MERGE)
    //@JsonManagedReference
    @JoinColumn(name = "customer_id", nullable = false,
            referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade=CascadeType.MERGE)
    //@JsonManagedReference
    @JoinColumn(name = "post_id", nullable = false,
            referencedColumnName = "id")
    private Post post;

    @Column(name = "body")
    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment() {}

    public Comment(String body, Post post, Customer customer) {
        this.body = body;
        this.post = post;
        this.customer = customer;
    }


}


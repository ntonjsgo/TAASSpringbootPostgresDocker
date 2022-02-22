package com.javasampleapproach.springrest.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade=CascadeType.MERGE)
    //@JsonManagedReference
    @JoinColumn(name = "customer_id", nullable = false,
            referencedColumnName = "id")
    private Customer customer;

    @OneToMany(cascade=CascadeType.MERGE)
    //@JsonManagedReference
    @JoinColumn(name = "comments_list", nullable = false)
    private List<Comment> comments_list;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    public long getId() {
        return id;
    }

    public List<Comment> getCommentsList() {
        return comments_list;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
        this.comments_list = new ArrayList<Comment>();
    }

    public Post(String title, String body, Customer customer) {
        this.title = title;
        this.body = body;
        this.customer = customer;
        this.comments_list = new ArrayList<Comment>();
    }


}


package com.javasampleapproach.springrest.postgresql.model;

public class CreatePostRequest {
    public String title;
    public String body;
    public Long customer_id;
    CreatePostRequest(String title, String body, Long customer_id) {
        this.title = title;
        this.body = body;
        this.customer_id = customer_id;
    }
}
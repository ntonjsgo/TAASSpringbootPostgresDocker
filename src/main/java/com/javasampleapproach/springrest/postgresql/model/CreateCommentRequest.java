package com.javasampleapproach.springrest.postgresql.model;

public class CreateCommentRequest {
    public String body;
    public Long customer_id;
    public Long post_id;
    CreateCommentRequest(String body, Long customer_id, Long post_id) {
        this.body = body;
        this.customer_id = customer_id;
        this.post_id = post_id;
    }
}
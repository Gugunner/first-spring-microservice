package com.gugunner.microservice.spring.service;

import com.gugunner.microservice.spring.model.Comment;

import java.io.IOException;
import java.util.List;

public interface CommentsService {
    String put(Comment model) throws IOException;

    List<Comment> list(String pageId) throws IOException;

    Comment get(String id);

    List<Comment> listSpamComments(String pageId) throws IOException;

    void delete(String id);
}

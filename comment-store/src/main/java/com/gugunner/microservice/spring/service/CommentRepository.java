package com.gugunner.microservice.spring.service;

import com.gugunner.microservice.spring.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {
    //  @Query("select a from Comment a where a.pageId = ?1")
    List<Comment> findByPageId(String pageId);

    List<Comment> findByPageIdAndSpamIsTrue(String pageId);
}

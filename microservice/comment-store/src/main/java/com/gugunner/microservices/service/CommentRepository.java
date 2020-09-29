package com.gugunner.microservices.service;

import com.gugunner.microservices.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CommentRepository extends CrudRepository<Comment, String> {
    //  @Query("select a from Comment a where a.pageId = ?1")
    List<Comment> findByPageId(String pageId);

    List<Comment> findByPageIdAndSpamIsTrue(String pageId);

    Page<Comment> findByPageId(String pageId, Pageable pageable);
}

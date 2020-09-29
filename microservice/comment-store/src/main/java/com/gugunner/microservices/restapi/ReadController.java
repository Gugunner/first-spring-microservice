package com.gugunner.microservices.restapi;

import com.gugunner.microservices.model.Comment;
import com.gugunner.microservices.service.CommentsService;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@RestController
public class ReadController {

    private static final Logger log = LoggerFactory.getLogger(ReadController.class);

    @Autowired
    private CommentsService service;

    @Autowired
    private MeterRegistry meterRegistry;

    @RequestMapping(value = "/comments/{id}")
    public List<Comment> getComments(@PathVariable(value = "id") String pageId) throws IOException {
        List<Comment> r = service.list(pageId);
        meterRegistry.counter("commentstore.list_comments").increment();
        if(r.isEmpty()) {
            throw new FileNotFoundException("/list/" +pageId);
        }
        return r;
    }

    @RequestMapping(value = "/comments/{id}/paging")
    public Page<Comment> getCommentsPaging(@PathVariable(value = "id") String pageId, Pageable pageable) throws IOException {
        return service.list(pageId, pageable);
    }

    @RequestMapping(value = "/comments/{id}/spam")
    public List<Comment> getSpamComments(@PathVariable(value = "id") String pageId) throws IOException {
        List<Comment> r = service.listSpamComments(pageId);
        if(r.isEmpty()) {
            throw new FileNotFoundException("/list/"+pageId);
        }
        return r;
    }

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handle404(Exception ex, Locale locale) {
        log.debug("Resources not found {}", ex.getMessage());
    }
    //Add this is you want a universal exception handler fallback
//    @ExceptionHandler(Exception.class)
//    public void error(Exception ex, Locale locale) {
//        ///
//    }
}

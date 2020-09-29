package com.gugunner.microservices.restapi;

import com.gugunner.microservices.model.Comment;
import com.gugunner.microservices.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WriteController {

    @Autowired
    private CommentsService service;

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody String create(@ModelAttribute Comment model) throws IOException {
        return service.put(model);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(
            @PathVariable(value = "id") String id,
            HttpServletResponse response) throws IOException {
        System.out.println("Deleting");
        service.delete(id);
    }
}

package com.gugunner.microservice.spring.boot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EntityScan(basePackages = {"com.gugunner.microservices.spring.model"})
public class CommentStoreApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommentStoreApp.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello world!";
    }
}

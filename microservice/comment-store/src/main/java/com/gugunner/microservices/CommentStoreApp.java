package com.gugunner.microservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gugunner.microservices.restapi.CreateComment;
import com.gugunner.microservices.restapi.ReadComment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Filter;

//@RestController
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = {"com.gugunner.microservices"})
//@EnableSpringDataWebSupport
public class CommentStoreApp {
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommentStoreApp.class, args);
    }

    @Bean
    CreateComment createCommentFunction() {
        return new CreateComment();
    }

    @Bean
    ReadComment readCommentFunction() {
        return new ReadComment();
    }

//    /**
//     * Maps the commons logging Filter to all requests; done by spring boot
//     * @return
//     */
//    @Bean
//    public Filter initRequestContextLoggingFilter() {
//        return new RequestContextLoggingFilter();
//    }
}

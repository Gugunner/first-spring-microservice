package com.gugunner.microservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
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

@RestController
@SpringBootApplication
@EnableTransactionManagement
//@ComponentScan(basePackages = {"com.gugunner.microservices"})
@EntityScan(basePackages = {"com.gugunner.microservices"})
@EnableSpringDataWebSupport
//@ImportResource(value = {"classpath*:legacy-context.xml"})
public class CommentStoreApp {
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommentStoreApp.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello world!";
    }

    //This is a basic redirection
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView method() {
//        return new ModelAndView("redirect:" + "/home");
//    }

    //Second way to override Jackson ObjectMapper instead of using application properties
//    @Bean
//    @Primary
//    public ObjectMapper initObjectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.registerModule(new JavaTimeModule());
//        return objectMapper;
//    }

    //Third way to use Jackson2ObjectMapperBuilder from Spring

    /**
     *
     * @param builder
     * @return
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder
                .failOnUnknownProperties(false)
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();
        return objectMapper;
    }

    /**
     * Maps the commons logging Filter to all requests; done by spring boot
     * @return
     */
    @Bean
    public Filter initRequestContextLoggingFilter() {
        return new RequestContextLoggingFilter();
    }
}

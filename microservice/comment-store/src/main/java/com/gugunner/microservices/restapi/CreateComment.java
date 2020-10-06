package com.gugunner.microservices.restapi;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gugunner.microservices.model.Comment;
import com.gugunner.microservices.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.function.Function;

@Component
public class CreateComment implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Autowired
    private CommentsService service;

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        String body = apiGatewayProxyRequestEvent.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Comment comment = null;
        String responseMessage = "";
        try {
            comment = mapper.readValue(body, Comment.class);
            responseMessage = service.put(comment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseEvent.setStatusCode(201);
        responseEvent.setBody(responseMessage);
        return responseEvent;
    }
}


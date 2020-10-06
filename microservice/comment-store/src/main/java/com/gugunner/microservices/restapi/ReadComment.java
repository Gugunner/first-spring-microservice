package com.gugunner.microservices.restapi;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gugunner.microservices.model.Comment;
import com.gugunner.microservices.service.CommentsService;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@Component
public class ReadComment implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Autowired
    private CommentsService service;

    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        String pageId = apiGatewayProxyRequestEvent.getPathParameters().get("id");
        ObjectMapper mapper = new ObjectMapper();
        List<Comment> r = null;
        String responseMessage = "";
        meterRegistry.counter("commentstore.list_comments").increment();
        try {
            r = service.list(pageId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            responseMessage = mapper.writeValueAsString(r);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        responseEvent.setStatusCode(200);
        responseEvent.setBody(responseMessage);
        return responseEvent;
    }
}

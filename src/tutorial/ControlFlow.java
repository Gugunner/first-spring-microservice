package com.gugunner.microservice.tutorial;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ControlFlow {

    private SpamDetector spamDetector;

    public ControlFlow(@Qualifier("simpleSpamDetector") SpamDetector spamDetector) {
        super();
        this.spamDetector = spamDetector;
    }

    public void run(String[] args) throws IOException {
        System.out.println("isSpam " + spamDetector.containsSpam(args[0]));
    }
}

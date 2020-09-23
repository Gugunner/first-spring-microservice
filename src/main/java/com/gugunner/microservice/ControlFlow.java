package com.gugunner.microservice;

import java.io.IOException;

public class ControlFlow {

    private SpamDetector spamDetector;

    public ControlFlow(SpamDetector spamDetector) {
        super();
        this.spamDetector = spamDetector;
    }

    public void run(String[] args) throws IOException {
        System.out.println(spamDetector.containsSpam(args[0]));
    }
}

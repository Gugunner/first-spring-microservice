package com.gugunner.microservice;

public class SpamCheckerApplication {
    public static void main(String[] args) throws Exception {
        SpamDetector spamDetector = SpamDetectorFactory.getInstance(args);
        System.out.println(spamDetector.containsSpam(args[0]));
    }
}

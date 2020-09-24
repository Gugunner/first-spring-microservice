package com.gugunner.microservices;

import java.io.IOException;

public class SpamDetectorFactory {

    public static SpamDetector getInstance(String[] args) throws IOException {
        if(args.length <= 2) {
//            List<String> spamWords = new ArrayList<>();
//            spamWords = Files.readAllLines(Paths.get(args[1]));
            return new SimpleSpamDetector(args[1]);
        }
        return new RemoteSpamDetector(args[0], args[1], args[2]);
    }
}
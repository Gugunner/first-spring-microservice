package com.gugunner.microservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SpamDetectorFactory {

    public static SpamDetector getInstance(String[] args) throws IOException {
        if(args.length <= 2) {
            List<String> spamWords = new ArrayList<>();
            spamWords = Files.readAllLines(Paths.get(args[1]));
            return new SimpleSpamDetector(spamWords);
        }
    return new RemoteSpamDetector(args[0], args[1], args[2]);
    }


}

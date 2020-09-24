package com.gugunner.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleSpamDetector implements SpamDetector {
    private List<String> spamWords = new ArrayList<String>();

    public SimpleSpamDetector(@Value("${sbb.spamwords.filename}") String filename) throws IOException {
        spamWords = Files.readAllLines(Paths.get(filename));
//        this.spamWords = spamWords;
    }

    @Override
    public boolean containsSpam(String value) {
        System.out.println("Value " + value);
        for(String spam : spamWords) {
            if(value.toLowerCase().contains(spam)) {
                return true;
            }
        }
        return false;
    }
}

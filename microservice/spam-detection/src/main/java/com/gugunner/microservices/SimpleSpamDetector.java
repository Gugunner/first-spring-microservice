package com.gugunner.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleSpamDetector implements SpamDetector {
    private List<String> spamWords = new ArrayList<String>();
    public SimpleSpamDetector(@Value("${sbb.spamwords.filename}") String filename) throws IOException {
        System.out.println("Lines " + Paths.get(filename));
        try {
            spamWords = Files.readAllLines(new File(filename).toPath());
            System.out.println("Lines " + Files.readAllLines(Paths.get(filename)));
        } catch (NoSuchFileException e) {
            System.out.println("File name " + filename);
            System.out.println("File not found");
        }
    }

    @Override
    public boolean containsSpam(String value) {
        System.out.println("Value " + value);
        System.out.println("Spam Words " + spamWords);
        for(String spam : spamWords) {
            if(value.toLowerCase().contains(spam)) {
                return true;
            }
        }
        return false;
    }
}

package com.gugunner.microservice;

import java.util.ArrayList;
import java.util.List;

public class SimpleSpamDetector implements SpamDetector {
    private List<String> spamWords = new ArrayList<String>();

    public SimpleSpamDetector(List<String> spamWords) {
        this.spamWords = spamWords;
    }

    @Override
    public boolean containsSpam(String value) {
        for(String spam : spamWords) {
            if(value.toLowerCase().contains(spam)) {
                return true;
            }
        }
        return false;
    }
}

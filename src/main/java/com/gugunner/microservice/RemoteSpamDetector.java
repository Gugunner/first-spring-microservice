package com.gugunner.microservice;

public class RemoteSpamDetector implements SpamDetector {

    public RemoteSpamDetector(String url, String username, String password) {
        // just example of scalability complexity
    }

    @Override
    public boolean containsSpam(String vale) {
        //makes remote call
        return false;
    }
}

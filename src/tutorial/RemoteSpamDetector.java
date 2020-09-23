package com.gugunner.microservice.tutorial;

//@Service
public class RemoteSpamDetector implements SpamDetector {

    private String url;
    private String username;
    private String password;

    public RemoteSpamDetector(String url, String username, String password) {
        // just example of scalability complexity
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean containsSpam(String vale) {
        //makes remote call
        return false;
    }
}

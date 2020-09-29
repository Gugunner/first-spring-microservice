package com.gugunner.microservices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//We use @ComoponentScan to scan all classes with @Component to add them as beans in this Configuration Object
// We no longer need to explicitly declare the beans in the config object
@Configuration
@ComponentScan
public class SpamAppConfig {
//    @Bean
//    public SpamDetector simpleSpamDetector(@Value("${sbb.spamwords.filename}") String filename) throws IOException {
//        List<String> spamWords;
//        System.out.println("File name " + filename);
//        spamWords = Files.readAllLines(Paths.get(filename));
//        return new SimpleSpamDetector(spamWords);
//    };
//
//    @Bean
//    public ControlFlow controlFlow(SpamDetector spamDetector) {
//        return new ControlFlow(spamDetector);
//    }

    //TODO Test hypotheis
//    @Bean
//    public RemoteSpamDetector remoteSpamDetector() {
//        return new RemoteSpamDetector("url", "hello", "passwprd");
//    }

}

package dev.spring.REST;

import org.springframework.stereotype.Component;

@Component
public class Message {
    public String getMessageString() {
        return "Hello World!";
    }
}

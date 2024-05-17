package com.example.springcloudfunction;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Hello implements Function<User, Greeting> {
    @Override
    public Greeting apply(User user) {
        return new Greeting("Hello, " + user.name() + "!\n");
    }
}

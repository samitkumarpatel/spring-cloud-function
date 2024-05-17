package com.example.springcloudfunction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {
    @Test
    public void test() {
        Greeting result = new Hello().apply(new User("foo"));
        assertThat(result.message()).isEqualTo("Hello, foo!\n");
    }
}

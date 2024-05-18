package com.example.springcloudfunction;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HelloHandler {
    final Hello hello;

    @FunctionName("hello")
    public HttpResponseMessage execute(
            @HttpTrigger(
                    name = "request",
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<User>> request, ExecutionContext context) {
        User user = request.getBody()
                .filter(u -> u.name() != null)
                .orElseGet(() -> new User(request.getQueryParameters().getOrDefault("name", "world")));
        context.getLogger().info("Greeting user name: " + user.name());
        return request.createResponseBuilder(HttpStatus.OK)
                .body(hello.apply(user))
                .header("Content-Type", "application/json")
                .build();
    }
}

package com.example.springcloudfunction;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class FunctionConfiguration {
    final Function<String, String> uppercase;
    final FunctionCatalog functionCatalog;

    @FunctionName("bean")
    public String plainBean(
            @HttpTrigger(
                    name = "req",
                    methods = { HttpMethod.GET, HttpMethod.POST },
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {
        return this.uppercase.apply(request.getBody().get());
    }

    @FunctionName("scf")
    public String springCloudFunction(
            @HttpTrigger(
                    name = "req",
                    methods = { HttpMethod.GET, HttpMethod.POST },
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {

        // Use SCF composition. Composed functions are not just spring beans but SCF such.
        Function composed = this.functionCatalog.lookup("reverse|uppercase");

        return (String) composed.apply(request.getBody().get());
    }
}

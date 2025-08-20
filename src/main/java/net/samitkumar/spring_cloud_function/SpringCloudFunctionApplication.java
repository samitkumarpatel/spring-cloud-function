package net.samitkumar.spring_cloud_function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class SpringCloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionApplication.class, args);
	}

	@Bean
	public Function<Flux<String>, Flux<String>> uppercase() {
		return flux -> flux.map(String::toUpperCase);
	}

}

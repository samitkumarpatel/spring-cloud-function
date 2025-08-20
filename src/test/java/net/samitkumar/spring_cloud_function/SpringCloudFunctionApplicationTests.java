package net.samitkumar.spring_cloud_function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
@AutoConfigureWebTestClient
class SpringCloudFunctionApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void contextLoads() {
	}

	@Test
	void testUppercase() {
		webTestClient
				.post()
				.uri("/uppercase")
				.bodyValue("""
							["hello", "world"]
						""")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody()
				.json("""
					[
						"HELLO",
						"WORLD"
					]
				""")

		;
	}

}

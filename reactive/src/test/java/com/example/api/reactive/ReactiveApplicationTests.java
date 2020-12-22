package com.example.api.reactive;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReactiveApplicationTests {

	@Autowired
	private WebTestClient testClient;
	
	@Test
	public void shouldReturnRecentIngredients() throws IOException {
		testClient.get().uri("/design/recentFlux").exchange().expectStatus().isOk()
		.expectBody()
		.jsonPath("$").isArray()
		.jsonPath("$").isNotEmpty()
		.jsonPath("$[0].id").isEqualTo("FLTO");
	}

}

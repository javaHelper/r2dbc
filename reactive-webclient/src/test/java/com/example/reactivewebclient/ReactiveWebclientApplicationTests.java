package com.example.reactivewebclient;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.reactivewebclient.model.Post;

@SpringBootTest
class ReactiveWebclientApplicationTests {

	private static final String BASE_URL = "http://localhost:3000/";
	private static WebClient webClient;
	
	
	@BeforeAll
	static void setWebClient() {
		webClient = WebClient.builder()
				.baseUrl(BASE_URL)
				.build();
	}
	
	// http://localhost:3000/posts
	@Test
	void get() {
		webClient.get()
			.uri("/posts")
			.retrieve()
			.bodyToMono(Post[].class)
			.flatMapIterable(Arrays::asList)
			.subscribe(System.out::println);
	}
	
	// http://localhost:3000/posts
	@Test
	void post() {
		Post p = Post.builder().id(2).author("Aravind").title("Java in Action 11").build();
		
		webClient.post()
			.uri("/posts")
			.body(BodyInserters.fromValue(p))
			.retrieve()
			.bodyToMono(String.class)
			.subscribe(System.out::println);
	}
	
	// http://localhost:3000/posts/2
	@Test
	void patch() {
		webClient.patch()
			.uri("/posts/2")
			.body(BodyInserters.fromFormData("title", "webClient"))
			.retrieve()
			.bodyToMono(String.class)
			.subscribe(System.out::println);
	}

	// http://localhost:3000/posts/2
	@Test
	void delete() {
		webClient.delete()
			.uri("/posts/2")
			.retrieve()
			.bodyToMono(String.class)
			.subscribe(System.out::println);
	}

	@AfterAll
	static void await() throws Exception{
		Thread.sleep(5000);
	}
}

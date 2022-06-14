package com.example.r2dbcpagination.service;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.example.r2dbcpagination.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DataSetupService implements CommandLineRunner {

	@Value("classpath:init.sql")
	private Resource initSql;

	@Autowired
	private R2dbcEntityTemplate entityTemplate;

	@Override
	public void run(String... args) throws Exception {
		String query = StreamUtils.copyToString(initSql.getInputStream(), StandardCharsets.UTF_8);
		this.entityTemplate
			.getDatabaseClient()
			.sql(query)
			.then()
			.then(insertProduct())
			.subscribe();
	}

	private Mono<Void> insertProduct(){
		return Flux.range(1, 100)
				.map(i -> Product.create(null, "product-"+i, ThreadLocalRandom.current().nextInt(1, 1000)))
				.flatMap(this.entityTemplate::insert)
				.doOnComplete(() -> System.out.println())
				.then();
	}
}

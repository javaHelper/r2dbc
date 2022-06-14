package com.example.r2dbccallback.callbacks;


import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;

import com.example.r2dbccallback.entity.Product;

import reactor.core.publisher.Mono;

@Component
public class ProductBeforeConvert implements BeforeConvertCallback<Product> {

	private static final String PATTERN = "[^a-zA-Z ]";

	@Override
	public Publisher<Product> onBeforeConvert(Product product, SqlIdentifier sqlIdentifier) {
		var updatedDescription = product.getDescription().replaceAll(PATTERN, "");
		System.out.println("Actual : " + product.getDescription());
		System.out.println("Updated : " + updatedDescription);
		product.setDescription(updatedDescription);
		
		return Mono.just(product);
	}

}
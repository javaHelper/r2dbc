package com.example.r2dbcpagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.r2dbcpagination.entity.Product;
import com.example.r2dbcpagination.repository.ProductRepository;

import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;


	public Mono<Page<Product>> getProducts(PageRequest pageRequest){
		return this.productRepository.findAllBy(pageRequest.withSort(Sort.by("price").descending()))
				.collectList()
				.zipWith(this.productRepository.count())
				.map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
	}
}

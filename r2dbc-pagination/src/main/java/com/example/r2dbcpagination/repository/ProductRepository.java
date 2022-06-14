package com.example.r2dbcpagination.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.example.r2dbcpagination.entity.Product;

import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveSortingRepository<Product, Integer>{
	Flux<Product> findAllBy(Pageable pageable);
}

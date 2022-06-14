package com.example.r2dbccallback.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.r2dbccallback.entity.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Flux<Product> getAllProduct(){
        return this.productRepository.findAll();
    }

    public Mono<Product> getProductById(int productId){
        return this.productRepository.findById(productId);
    }

    public Mono<Product> createProduct(Product product){
        return this.productRepository.save(product);
    }

    // Upsert case
    public Mono<Product> updateProduct(int productId, Mono<Product> productMono){
        return this.productRepository.findById(productId)
                .flatMap(p -> productMono.map(u -> {
                    p.setDescription(u.getDescription());
                    p.setPrice(u.getPrice());
                    return p;
                }))
                .flatMap(p -> this.productRepository.save(p));
    }

    public Mono<Void> deleteProduct(int productId){
        return this.productRepository.deleteById(productId);
    }
}

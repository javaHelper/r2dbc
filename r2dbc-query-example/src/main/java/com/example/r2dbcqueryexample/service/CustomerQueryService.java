package com.example.r2dbcqueryexample.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.example.r2dbcqueryexample.entity.Customer;
import com.example.r2dbcqueryexample.repository.CustomerRepository;

import reactor.core.publisher.Flux;

@Service
public class CustomerQueryService {

	@Autowired
    private CustomerRepository repository;

    private final Map<String, String> countryMap = Map.of(
            "BR", "Brazil",
            "CH", "China"
    );

    public Flux<Customer> search(Customer customer){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withTransformer("country", op -> op.map(c -> countryMap.getOrDefault(c, "UNKNOWN")));
        return this.repository.findAll(Example.of(customer, matcher));
    }
    
    public Flux<Customer> insensitiveSearch(Customer customer){
        return this.repository.findAll(Example.of(customer, ExampleMatcher.matching().withIgnoreCase()));
    }
    
    public Flux<Customer> insensitiveSearchForSpecificField(Customer customer){
        return this.repository.findAll(Example.of(customer, ExampleMatcher.matching().withIgnoreCase("lastName")));
    }
}

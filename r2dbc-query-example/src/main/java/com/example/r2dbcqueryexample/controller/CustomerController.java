package com.example.r2dbcqueryexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.r2dbcqueryexample.entity.Customer;
import com.example.r2dbcqueryexample.service.CustomerQueryService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
    private CustomerQueryService queryService;
	
	@GetMapping("search")
    public Flux<Customer> search(Customer customerSearchCriteria){
        return this.queryService.search(customerSearchCriteria);
    }
	
	@GetMapping("insensativeSearch")
    public Flux<Customer> insensativeSearch(Customer customerSearchCriteria){
        return this.queryService.insensitiveSearch(customerSearchCriteria);
    }
	
	@GetMapping("insensitiveSearchForSpecificField")
    public Flux<Customer> insensitiveSearchForSpecificField(Customer customerSearchCriteria){
        return this.queryService.insensitiveSearchForSpecificField(customerSearchCriteria);
    }
}

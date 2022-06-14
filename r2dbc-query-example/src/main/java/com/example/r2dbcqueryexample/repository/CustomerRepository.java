package com.example.r2dbcqueryexample.repository;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.r2dbcqueryexample.entity.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer>, ReactiveQueryByExampleExecutor<Customer>{

}

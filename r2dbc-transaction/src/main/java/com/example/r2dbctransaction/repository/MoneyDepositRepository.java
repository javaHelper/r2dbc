package com.example.r2dbctransaction.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.r2dbctransaction.entity.MoneyDepositEvent;

@Repository
public interface MoneyDepositRepository extends ReactiveCrudRepository<MoneyDepositEvent, Integer> {
}

package com.example.r2dbctransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;

import com.example.r2dbctransaction.dto.DepositRequest;
import com.example.r2dbctransaction.entity.MoneyDepositEvent;
import com.example.r2dbctransaction.repository.AccountRepository;
import com.example.r2dbctransaction.repository.MoneyDepositRepository;

import reactor.core.publisher.Mono;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MoneyDepositRepository eventRepository;

    @Autowired
    private TransactionalOperator operator;

    public Mono<Void> deposit(DepositRequest request){
        return this.accountRepository.findById(request.getAccount())
                    .doOnNext(ac -> ac.setBalance(ac.getBalance() + request.getAmount()))
                    .flatMap(this.accountRepository::save)
                    .thenReturn(toEvent(request))
                    .flatMap(this.eventRepository::save)
                    .as(operator::transactional)
                    .then();
    }

    // create money deposit event from request
    private MoneyDepositEvent toEvent(DepositRequest request){
        return MoneyDepositEvent.create(
                null,
                    request.getAccount(),
                    request.getAmount()
        );
    }

}

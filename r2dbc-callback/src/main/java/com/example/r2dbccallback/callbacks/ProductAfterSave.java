package com.example.r2dbccallback.callbacks;

import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;

import com.example.r2dbccallback.entity.Product;

import reactor.core.publisher.Mono;


@Component
public class ProductAfterSave implements AfterSaveCallback<Product> {

	@Override
    public Publisher<Product> onAfterSave(Product product, OutboundRow outboundRow, SqlIdentifier sqlIdentifier) {
        System.out.println("After save");
        System.out.println(outboundRow.entrySet());
        
        return Mono.just(product);
    }
}

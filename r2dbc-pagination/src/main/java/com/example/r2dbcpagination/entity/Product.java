package com.example.r2dbcpagination.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Data
@Builder
public class Product {
	@Id
    private Integer id;
    private String description;
    private Integer price;
}

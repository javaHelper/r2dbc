package com.example.r2dbcqueryexample.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {

	@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private Boolean isActive;
}

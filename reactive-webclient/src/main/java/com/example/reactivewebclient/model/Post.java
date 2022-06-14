package com.example.reactivewebclient.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Post {

	private int id;
	private String title;
	private String author;

}
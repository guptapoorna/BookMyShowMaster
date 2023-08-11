package com.fs30.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {

	public static void main(String[] args) {
		System.out.println("Book My Show application Started.");
		SpringApplication.run(BookMyShowApplication.class, args);
		System.out.println("Book My Show application ended.");

	}

}

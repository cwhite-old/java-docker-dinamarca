package com.celsia.dinamarca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DinamarcaServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinamarcaServicesApplication.class, args);
	}

}

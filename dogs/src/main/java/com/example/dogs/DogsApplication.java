package com.example.dogs;

import com.example.dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DogsApplication {

	@Autowired
	DogRepository dogRepository;

	public static void main(String[] args) {
		SpringApplication.run(DogsApplication.class, args);
	}
}

package com.dario.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={
		"com.dario.demo", "com.dario.sequence"})
public class SpringBootMongoRestApiApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootMongoRestApiApplication.class, args);
	}
}

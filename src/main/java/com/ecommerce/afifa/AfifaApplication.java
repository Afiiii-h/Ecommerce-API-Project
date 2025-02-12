package com.ecommerce.afifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AfifaApplication {

	public static void main(String[] args) {

		SpringApplication.run(AfifaApplication.class, args);
	}

}

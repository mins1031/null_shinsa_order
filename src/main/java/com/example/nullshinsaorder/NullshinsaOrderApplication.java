package com.example.nullshinsaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NullshinsaOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NullshinsaOrderApplication.class, args);
	}

}

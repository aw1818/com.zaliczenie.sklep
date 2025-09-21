package com.zaliczenie.sklep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories(basePackages = "com.zaliczenie.sklep.products.repository")
@EnableWebMvc
@SpringBootApplication
public class SklepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SklepApplication.class, args);
	}

}

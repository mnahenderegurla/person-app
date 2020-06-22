package com.person.personapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.person")
@EnableJpaRepositories("com.person.repository")
public class PersonAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonAppApplication.class, args);
	}

}

package com.wab.clima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories("com.wab.clima.model.repositories")
@EntityScan("com.wab.clima.model.entities")
public class ClimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimaApplication.class, args);
	}

}

package com.springcourse.sectionfour.springApiRestfulStudy;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Cliente;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebApiRestfulApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ClienteRepository clientes){
		return args -> {
			Cliente cliente = new Cliente(null, "Fulano");
			clientes.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApiRestfulApplication.class, args);
	}

}

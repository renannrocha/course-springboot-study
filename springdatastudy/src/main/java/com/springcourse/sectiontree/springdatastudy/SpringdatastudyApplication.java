package com.springcourse.sectiontree.springdatastudy;

import com.springcourse.sectiontree.springdatastudy.domain.entities.Cliente;
import com.springcourse.sectiontree.springdatastudy.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringdatastudyApplication {

	//test
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clientes){
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setName("Renan");
			clientes.salvarCliente(cliente);

			Cliente cliente2 = new Cliente();
			cliente2.setName("Fernando");
			clientes.salvarCliente(cliente2);

			List<Cliente> allClients = clientes.listarClientes();
			allClients.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdatastudyApplication.class, args);
	}

}

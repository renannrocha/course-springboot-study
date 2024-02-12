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
			System.out.println("\ninserindo clientes\n");

			clientes.save(new Cliente("Renan"));
			clientes.save(new Cliente("Fernando"));
			clientes.save(new Cliente("Jóse"));
			clientes.save(new Cliente("Gabriel"));
			clientes.save(new Cliente("Maria"));


			List<Cliente> allClients = clientes.findAll();
			allClients.forEach(System.out::println);

			System.out.println("\natualizando clientes\n");

			allClients.forEach(c -> {
				c.setName(c.getName() + " atualizado");
				clientes.save(c);
			});

			allClients = clientes.findAll();
			allClients.forEach(System.out::println);

			System.out.println("\nbuscando clientes\n");

			clientes.findByNameLike("Fer").forEach(System.out::println);

			System.out.println("\natualizando clientes\n");

			clientes.findAll().forEach( c -> {
				clientes.delete(c);
			});

			allClients = clientes.findAll();
			if (allClients.isEmpty()){
				System.out.println("nenhum cliente encontrado");
			} else {
				allClients.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdatastudyApplication.class, args);
	}

}

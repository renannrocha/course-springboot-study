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

			Cliente cliente = new Cliente();
			cliente.setName("Renan");
			clientes.salvarCliente(cliente);

			Cliente cliente2 = new Cliente();
			cliente2.setName("Fernando");
			clientes.salvarCliente(cliente2);

			List<Cliente> allClients = clientes.listarClientes();
			allClients.forEach(System.out::println);

			System.out.println("\natualizando clientes\n");

			allClients.forEach(c -> {
				c.setName(c.getName() + " atualizado");
				clientes.atualizarClente(c);
			});

			allClients = clientes.listarClientes();
			allClients.forEach(System.out::println);

			System.out.println("\nbuscando clientes\n");

			clientes.listarPorNome("Fer").forEach(System.out::println);

			System.out.println("\natualizando clientes\n");

			clientes.listarClientes().forEach( c -> {
				clientes.deletarCliente(c);
			});

			allClients = clientes.listarClientes();
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

package com.springcourse.sectiontree.springdatastudy;

import com.springcourse.sectiontree.springdatastudy.domain.entities.Cliente;
import com.springcourse.sectiontree.springdatastudy.domain.entities.Pedido;
import com.springcourse.sectiontree.springdatastudy.domain.repositories.ClienteRepository;
import com.springcourse.sectiontree.springdatastudy.domain.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringdatastudyApplication {

	//test
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clientes, @Autowired PedidoRepository pedidos){
		return args -> {
			System.out.println("\ninserindo clientes\n");

			Cliente c1 = new Cliente("José Fernado Vieira");
			clientes.save(c1);

			Pedido p = new Pedido();
			p.setCliente(c1);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			pedidos.save(p);

			/*Cliente cliente1 = clientes.findClienteFetchPedidos(c1.getId());
			System.out.println(cliente1);
			System.out.println(cliente1.getPedidos());*/

			pedidos.findByCliente(c1).forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdatastudyApplication.class, args);
	}

}

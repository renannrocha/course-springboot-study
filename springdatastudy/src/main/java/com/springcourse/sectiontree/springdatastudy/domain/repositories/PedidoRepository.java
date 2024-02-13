package com.springcourse.sectiontree.springdatastudy.domain.repositories;

import com.springcourse.sectiontree.springdatastudy.domain.entities.Cliente;
import com.springcourse.sectiontree.springdatastudy.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Set<Pedido> findByCliente(Cliente cliente);
}

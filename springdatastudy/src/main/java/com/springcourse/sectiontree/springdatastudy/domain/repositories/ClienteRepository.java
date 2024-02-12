package com.springcourse.sectiontree.springdatastudy.domain.repositories;

import com.springcourse.sectiontree.springdatastudy.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // as funções de persistencias de dados são herdadas pelo JPARepository
    List<Cliente> findByNameLike(String nome);

    // Query methods
    List<Cliente> findByNameOrIdOrderById(String nome, Integer id);

}

package com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories;

import ch.qos.logback.core.net.server.Client;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNameLike(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos p where c.id =:id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}

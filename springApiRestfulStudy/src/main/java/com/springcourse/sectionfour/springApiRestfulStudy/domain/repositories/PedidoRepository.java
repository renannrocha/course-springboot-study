package com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}

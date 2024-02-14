package com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}

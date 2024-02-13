package com.springcourse.sectiontree.springdatastudy.domain.repositories;

import com.springcourse.sectiontree.springdatastudy.domain.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}

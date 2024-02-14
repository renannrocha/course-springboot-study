package com.springcourse.sectiontree.springdatastudy.domain.repositories;

import com.springcourse.sectiontree.springdatastudy.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}

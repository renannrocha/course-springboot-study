package com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}

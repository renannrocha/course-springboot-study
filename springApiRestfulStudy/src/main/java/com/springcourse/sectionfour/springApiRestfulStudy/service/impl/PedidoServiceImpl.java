package com.springcourse.sectionfour.springApiRestfulStudy.service.impl;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.PedidoRepository;
import com.springcourse.sectionfour.springApiRestfulStudy.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

}

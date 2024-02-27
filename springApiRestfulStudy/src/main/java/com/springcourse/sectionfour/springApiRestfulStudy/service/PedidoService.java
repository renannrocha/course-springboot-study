package com.springcourse.sectionfour.springApiRestfulStudy.service;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Pedido;
import com.springcourse.sectionfour.springApiRestfulStudy.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar (PedidoDTO dto);
}

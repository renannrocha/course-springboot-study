package com.springcourse.sectionfour.springApiRestfulStudy.rest.controller;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Pedido;
import com.springcourse.sectionfour.springApiRestfulStudy.rest.dto.PedidoDTO;
import com.springcourse.sectionfour.springApiRestfulStudy.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}

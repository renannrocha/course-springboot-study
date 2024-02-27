package com.springcourse.sectionfour.springApiRestfulStudy.service.impl;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Cliente;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.ItemPedido;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Pedido;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Produto;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.ClienteRepository;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.ItemPedidoRepository;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.PedidoRepository;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.ProdutoRepository;
import com.springcourse.sectionfour.springApiRestfulStudy.exceptions.RegraNegocioException;
import com.springcourse.sectionfour.springApiRestfulStudy.rest.dto.ItemPedidoDTO;
import com.springcourse.sectionfour.springApiRestfulStudy.rest.dto.PedidoDTO;
import com.springcourse.sectionfour.springApiRestfulStudy.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(
                () -> new RegraNegocioException("Código de cliente invalido.")
        );

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedidos = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemPedidoRepository.saveAll(itemsPedidos);
        pedido.setItems(itemsPedidos);
        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if (items.isEmpty()){
            throw new RegraNegocioException("Não é possivel realizar um pedido sem items.");
        }

        return items.stream().map(dto -> {
           Integer idProduto = dto.getProduto();
           Produto produto = produtoRepository.findById(idProduto).orElseThrow(
                   () -> new RegraNegocioException("Código de produto invalido : " + idProduto)
           );

           ItemPedido itemPedido = new ItemPedido();
           itemPedido.setQuantidade(dto.getQuantidade());
           itemPedido.setPedido(pedido);
           itemPedido.setProduto(produto);
           return itemPedido;
        }).collect(Collectors.toList());
    }
}

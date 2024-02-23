package com.springcourse.sectionfour.springApiRestfulStudy.rest.controller;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Produto;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.ProdutoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController (ProdutoRepository produtoRepository){
        this.repository = produtoRepository;
    }

    @GetMapping(value = "/{id}")
    public Produto getProdutoById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.findById(id).map(produto ->{
            repository.delete(produto);
            return produto;
        }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não localizado")
        );
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@PathVariable Integer id, @RequestBody Produto produto){
        repository.findById(id).map(produtoExistente -> {
            produto.setId(produtoExistente.getId());
            repository.save(produto);
            return produtoExistente;
        }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não localizado")
        );
    }

    @GetMapping
    public List<Produto> find(Produto filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Produto> lista = repository.findAll(example);
        return repository.findAll(example);
    }
}

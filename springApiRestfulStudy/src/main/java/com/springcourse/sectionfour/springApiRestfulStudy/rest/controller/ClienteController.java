package com.springcourse.sectionfour.springApiRestfulStudy.rest.controller;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Cliente;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.ClienteRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    private ClienteRepository repository;

    public ClienteController(ClienteRepository clienteRepository){
        this.repository = clienteRepository;
    }

    @GetMapping(value = "/{id}")
    public Cliente getClienteById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND , "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @RequestBody Cliente cliente ){
        return repository.save(cliente);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return cliente;
        }).orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND , "Cliente não encontrado"));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Cliente cliente){
        repository.findById(id).map(clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            repository.save(cliente);
            return clienteExistente;
        }).orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND , "Cliente não encontrado"));
    }

    @GetMapping
    public List<Cliente> find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher
                                        .matching()
                                        .withIgnoreCase()
                                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = repository.findAll(example);
        return repository.findAll(example);
    }
}

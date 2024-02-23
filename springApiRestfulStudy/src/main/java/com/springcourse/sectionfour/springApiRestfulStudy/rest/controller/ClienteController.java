package com.springcourse.sectionfour.springApiRestfulStudy.rest.controller;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Cliente;
import com.springcourse.sectionfour.springApiRestfulStudy.domain.repositories.ClienteRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    private ClienteRepository repository;

    public ClienteController(ClienteRepository clienteRepository){
        this.repository = clienteRepository;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity save( @RequestBody Cliente cliente ){
        Cliente clienteSalvo = repository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isPresent()){
            repository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente){
        return repository.findById(id).map(clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            repository.save(cliente);
            return ResponseEntity.ok().build();
        }).orElseGet( () -> ResponseEntity.notFound().build());
    }
}

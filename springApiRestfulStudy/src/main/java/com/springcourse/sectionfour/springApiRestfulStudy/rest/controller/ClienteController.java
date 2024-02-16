package com.springcourse.sectionfour.springApiRestfulStudy.rest.controller;

import com.springcourse.sectionfour.springApiRestfulStudy.domain.entites.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @RequestMapping(
            value = "/hello/{nome}",
            method = RequestMethod.GET,
            // forma de como recebemos um objeto
            consumes = {"aplication/json" , "aplication/xml"}, // faz mais sentido com metodo POST,
            // forma de retorno dos nossos objetos
            produces = {"aplication/json" , "aplication/xml"}
    )
    @ResponseBody
    public String helloClientes (@PathVariable("nome") String nomeCliente){
        return String.format("Hello %s ", nomeCliente);
    }

}

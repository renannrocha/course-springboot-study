package com.springcourse.sectionfour.springApiRestfulStudy.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @RequestMapping(value = "/hello/{nomeCliente}", method = RequestMethod.GET)
    @ResponseBody
    public String helloClientes (@PathVariable String nomeCliente){
        return String.format("Hello %s ", nomeCliente);
    }

}

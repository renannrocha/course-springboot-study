package com.springcourse.sectiontwo.springstudypartone.service;

import com.springcourse.sectiontwo.springstudypartone.entities.User;

import com.springcourse.sectiontwo.springstudypartone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /* // 1. injeção simples
    * @Autowired
    * private UserRepository repository;
    * */

    /*
     * // 2. injeção por set
     * @Autowired
     * public void setRepository(UserRepository repository){
     *      this.repository = repository;
     * }
     * */

    private UserRepository repository;

    // 3. injeção atravez de um construtor
    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public void salvarUsuario(User user){
        validarUsuario(user);
        this.repository.persist(user);

        // operação para salvar cliente
    }

    public void validarUsuario(User user){
        // codigo de validação
    }

}

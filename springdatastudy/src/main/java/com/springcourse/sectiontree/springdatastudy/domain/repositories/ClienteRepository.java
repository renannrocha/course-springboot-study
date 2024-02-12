package com.springcourse.sectiontree.springdatastudy.domain.repositories;

import com.springcourse.sectiontree.springdatastudy.domain.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private EntityManager entityManager;

    //insert
    @Transactional
    public Cliente salvarCliente(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    //update
    @Transactional
    public Cliente atualizarClente(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }

    //delete
    @Transactional
    public void deletarCliente(Cliente cliente){
        if (!entityManager.contains(cliente)){
             cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    // delete by id
    @Transactional
    public void deletarClienteById(Integer id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletarCliente(cliente);
    }

    //listar por nome
    @Transactional(readOnly = true)
    public List<Cliente> listarPorNome(String nome){
        String jpql = " select c from Cliente c where c.name like :nome ";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    //list
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes (){
        return entityManager
                .createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

}

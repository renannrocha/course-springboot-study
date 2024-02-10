package com.springcourse.sectiontree.springdatastudy.domain.repositories;

import ch.qos.logback.core.net.server.Client;
import com.springcourse.sectiontree.springdatastudy.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository {

    // queries
    private static String INSERT = "insert into cliente (nome) values (?) ";
    private static String SELECT_ALL = "select * from cliente ";
    private static String DELETE = "delete from cliente where id = ? ";
    private static String UPDATE = "update cliente set nome = ? where id = ? ";

    //JDBC template
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //insert
    public Cliente salvarCliente(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{
                cliente.getName()
        });
        return cliente;
    }

    //update
    public Cliente atualizarClente(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{
                cliente.getName(),
                cliente.getId()
        });
        return cliente;
    }

    //delete
    public void deletarCliente(Cliente cliente){
        deletarClienteById(cliente.getId());
    }

    // delete by id
    public void deletarClienteById(Integer id) {
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    //listar por nome
    public List<Cliente> listarPorNome(String nome){
        return jdbcTemplate.query(
                SELECT_ALL.concat("where nome like ?"),
                new Object[]{"%" + nome + "%"},
                obterClienteMapper()
        );
    }

    //list
    public List<Cliente> listarClientes (){
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private static RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                // table id e nome
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }
}

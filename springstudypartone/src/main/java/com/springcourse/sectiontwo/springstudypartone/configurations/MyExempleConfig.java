package com.springcourse.sectiontwo.springstudypartone.configurations;

import com.springcourse.sectiontwo.springstudypartone.Development;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Development // criar anotation customizadas para referenciar as configurações
public class MyExempleConfig {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
              System.out.println("Aplicação executando em anbiente de desenvolvimento");
        };
    }
}

package com.springcourse.sectiontwo.springstudypartone.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development") // determina em qual perfil as configurações serão autorizadas
public class MyExempleConfig {

    // testar se aplicação esta rodando no perfil development
    @Bean
    public CommandLineRunner executar(){
        return args -> {
              System.out.println("Aplicação executando em anbiente de desenvolvimento");
        };
    }

}

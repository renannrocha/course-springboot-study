package com.springcourse.sectiontwo.springstudypartone.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyExempleConfig {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Minha Aplicação Spring Boot";
    }
}

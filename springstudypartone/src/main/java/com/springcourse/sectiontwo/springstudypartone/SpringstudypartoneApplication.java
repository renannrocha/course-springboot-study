package com.springcourse.sectiontwo.springstudypartone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringstudypartoneApplication {

	@Value("${application.name}")
	private String applicationName;

	@GetMapping("/hello")
	public String helloWord(){
		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringstudypartoneApplication.class, args);
	}

}

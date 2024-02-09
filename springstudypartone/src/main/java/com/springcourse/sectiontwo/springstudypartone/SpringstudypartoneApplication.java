package com.springcourse.sectiontwo.springstudypartone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringstudypartoneApplication {

	@GetMapping("/hello")
	public String helloWord(){
		return "Hello Word !";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringstudypartoneApplication.class, args);
	}

}

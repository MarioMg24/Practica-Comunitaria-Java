package com.mario.springboot.practica;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootPostgreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPostgreApplication.class, args);
	}
	
	@Bean
	public JtsModule jtsModule() {
		System.out.println("Modulo JTS cargado correctamente");
		return new JtsModule();
	}

}

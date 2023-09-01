package com.shivbhakt.shivbhakt;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShivbhaktApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShivbhaktApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper (){
		return  new ModelMapper();
	}


}

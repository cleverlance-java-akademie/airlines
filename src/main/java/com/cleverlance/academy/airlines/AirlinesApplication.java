package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.repositories.AirplaneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AirlinesApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(AirlinesApplication.class, args);
		AirplaneRepository ar = ctx.getBean(AirplaneRepository.class);
		ar.createAirplane(new Airplane("CZ",50,60,250));


	}

}

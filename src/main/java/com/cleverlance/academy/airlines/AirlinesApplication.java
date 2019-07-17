package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.Repository.AirPlaneRepository;
import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AirlinesApplication {

	public static void main(String[] args){

		ApplicationContext ctx =  SpringApplication.run(AirlinesApplication.class);
		AirPlaneRepository repo = ctx.getBean(AirPlaneRepository.class);
		repo.createPlane(new Airplane(1,"Ok1234", 15, 15));
	}
}

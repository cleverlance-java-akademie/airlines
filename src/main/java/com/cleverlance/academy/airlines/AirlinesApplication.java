package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.repositories.AirplaneRepository;
import com.cleverlance.academy.airlines.service.AirplaneService;
import com.cleverlance.academy.airlines.service.DestinationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AirlinesApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(AirlinesApplication.class, args);
//		AirplaneService ar = ctx.getBean(AirplaneService.class);
//		ar.addPlane(new Airplane("CZ",50,60,250));
		DestinationService ds = ctx.getBean(DestinationService.class);
		ds.storeAllDestination();



	}

}

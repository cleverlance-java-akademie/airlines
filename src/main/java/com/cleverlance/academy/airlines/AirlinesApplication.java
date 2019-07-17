package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.servicies.HangarService;
import com.cleverlance.academy.airlines.servicies.PlaneService;
import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AirlinesApplication {

	public static void main(String[] args){

		ApplicationContext ctx =  SpringApplication.run(AirlinesApplication.class);
		PlaneService ser = ctx.getBean(PlaneService.class);
		HangarService hSer = ctx.getBean(HangarService.class);
		ser.createPlane(Airplane.builder()
				.id(1)
				.code("OK1234")
				.numOfSeatsInFC(25)
				.numOfSeatsInEC(123)
				.build());
		hSer.createHangar(Hangar.builder()
				.id(1)
				.name("Pavlovo")
				.build());

	}
}

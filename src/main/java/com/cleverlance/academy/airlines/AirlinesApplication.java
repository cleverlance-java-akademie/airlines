package com.cleverlance.academy.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AirlinesApplication
{
    public static void main(String[] args)
    {


        SpringApplication.run(AirlinesApplication.class, args);
    }

}

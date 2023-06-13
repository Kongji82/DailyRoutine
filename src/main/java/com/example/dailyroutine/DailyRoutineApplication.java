package com.example.dailyroutine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DailyRoutineApplication {
	public static void main(String[] args) {
		SpringApplication.run(DailyRoutineApplication.class, args);
	}

}

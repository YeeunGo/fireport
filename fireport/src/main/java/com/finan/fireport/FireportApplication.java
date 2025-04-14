package com.finan.fireport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FireportApplication {

	public static void main(String[] args) {
		SpringApplication.run(FireportApplication.class, args);
	}

}

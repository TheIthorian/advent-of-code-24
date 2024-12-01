package com.theithorian.aoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AocApplication.class, args);
	}

}

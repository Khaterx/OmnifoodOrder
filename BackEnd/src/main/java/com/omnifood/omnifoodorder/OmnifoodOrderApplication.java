package com.omnifood.omnifoodorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync

public class OmnifoodOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmnifoodOrderApplication.class, args);
	}

}

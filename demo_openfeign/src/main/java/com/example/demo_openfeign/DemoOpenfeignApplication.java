package com.example.demo_openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoOpenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOpenfeignApplication.class, args);
	}

}

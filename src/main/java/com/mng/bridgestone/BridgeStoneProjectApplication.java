package com.mng.bridgestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BridgeStoneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeStoneProjectApplication.class, args);
	}

}

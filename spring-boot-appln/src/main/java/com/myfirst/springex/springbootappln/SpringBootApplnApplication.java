package com.myfirst.springex.springbootappln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.myfirst.springex")
public class SpringBootApplnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplnApplication.class, args);
	}
}

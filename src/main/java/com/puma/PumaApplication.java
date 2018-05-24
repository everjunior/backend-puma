package com.puma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PumaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PumaApplication.class, args);
	}
}

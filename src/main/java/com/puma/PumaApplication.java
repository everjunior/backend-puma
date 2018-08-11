package com.puma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PumaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PumaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}
}

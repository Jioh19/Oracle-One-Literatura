package com.alura.literatura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.literatura.controller.Principal;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	@Autowired
	Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) {

		principal.muestraApi();

	}
}

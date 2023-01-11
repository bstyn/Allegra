package com.example.Allegra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class AllegraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllegraApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(ApplicationContext ctx){
		return args -> {
			System.out.println("Beeaans");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}

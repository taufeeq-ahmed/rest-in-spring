package dev.spring.REST;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RestApplication.class, args);
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
	}

}

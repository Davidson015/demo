
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//
//		int a = input.nextInt();
//		int b = input.nextInt();
//		System.out.println(calc.add(a,b));

		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}



	@Override
	public void run(String... args) throws Exception {
		ScientificCalculator calculate =  applicationContext.getBean(ScientificCalculator.class);
		System.out.println(calculate.add(1,4));
	}
}
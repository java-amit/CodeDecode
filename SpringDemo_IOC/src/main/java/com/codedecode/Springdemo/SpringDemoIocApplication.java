package com.codedecode.Springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.codedecode.Springdemo.Demos.Car;

@SpringBootApplication
public class SpringDemoIocApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDemoIocApplication.class, args);
		Car car = context.getBean(Car.class);
		System.out.println(car.getEngineData());
	}

}

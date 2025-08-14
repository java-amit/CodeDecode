package com.codedecode.SpringDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codedecode.SpringDemo.Demos.Car;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context =  SpringApplication.run(SpringDemoApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		
		Car car = context.getBean(Car.class);
		System.out.println(car.getEngineData());
	}

}

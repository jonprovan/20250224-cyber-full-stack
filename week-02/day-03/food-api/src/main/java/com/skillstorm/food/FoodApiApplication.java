package com.skillstorm.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * this class is the starting point for our application
 * @SpringBootApplication is a composite annotation consisting of three other annotations:
 * - @SpringBootConfiguration = this class is able to generate Beans via methods that will be added to the ApplicationContext 
 * 								and that we can inject elsewhere
 * - @EnableAutoConfiguration = enables automatic configuration of the application unless we override that configuration somewhere
 * - @ComponentScan = scans this package and any subpackages for components, beans, etc. that will get added to the ApplicationContext
 * --- CAREFUL!! if you create a Component in a package that is NOT a subpackage of this one, it WILL NOT BE FOUND!!
 */

@SpringBootApplication
public class FoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApiApplication.class, args);
	}

}

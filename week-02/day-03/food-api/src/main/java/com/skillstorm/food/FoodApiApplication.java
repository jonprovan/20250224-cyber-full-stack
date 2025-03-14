package com.skillstorm.food;

import java.util.Arrays;
import java.util.LinkedList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

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
	
	// quick security customization via a configuration Bean
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// starting off the process
		http.httpBasic(Customizer.withDefaults());
		
		// disabling Cross-Site Resource Forgery protection for now
		http.csrf().disable();
		
		// bypassing Cross-Origin Resource Sharing protection for now
		http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(request -> {
	           CorsConfiguration cc = new CorsConfiguration().applyPermitDefaultValues();
	           cc.setAllowedMethods(new LinkedList<>(Arrays.asList("GET", "POST", "PUT", "DELETE")));
	           return cc;
			})
	    );
		
		http.authorizeHttpRequests(requests -> {
			
			// saying whether or not requests of certain methods/endpoints are allowed or denied
			// once a request matches one of these, top-down, the rest are ignored!
			requests.requestMatchers(HttpMethod.GET, "/**").permitAll();
			requests.anyRequest().permitAll();
			
		});
		
		return http.build();
		
	}

}

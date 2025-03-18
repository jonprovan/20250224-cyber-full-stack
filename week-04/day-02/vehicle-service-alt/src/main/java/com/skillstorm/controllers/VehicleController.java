package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Vehicle;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	private List<Vehicle> vehicles = new LinkedList<>(Arrays.asList(new Vehicle("Lamborghini", "Gallardo", 2010),
																	new Vehicle("Dodge", "Charger R/T", 1969),
																	new Vehicle("Honda", "Civic", 2001),
																	new Vehicle("Ford", "GTO 500", 1967)));
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		return ResponseEntity.ok(vehicles);
	}
	
	@GetMapping("/lb")
	public ResponseEntity<String> getServiceLabel() {
		return ResponseEntity.ok("Alternate Vehicle Service");
	}
	
	@PostMapping("/bycategory")
	public ResponseEntity<List<Vehicle>> getAllByCategory(@RequestBody Set<String> models) {
		List<Vehicle> matches = new LinkedList<>();
		for (String model : models) {
			for (Vehicle vehicle : vehicles) {
				if (model.equals(vehicle.model())) {
					matches.add(vehicle);
				}
			}
		}
		return ResponseEntity.ok(matches);
	}

}

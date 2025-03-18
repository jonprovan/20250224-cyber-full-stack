package com.skillstorm.api;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.skillstorm.models.Vehicle;

// you MUST match the service name here exactly
// methods listed in this interface are the ONLY methods you'll be able to use to communicate with this service
// however, you only need to list the cross-service methods here
@FeignClient(name = "vehicle-service")
public interface VehicleServiceClient {
	
	// here, we use PostMapping to indicate what type of request this will send to the other service
	// you must include the entire URL suffix for that endpoint
	// return type is whatever you'll get from the other service
	// parameter(s) are whatever you're sending with the request
	@PostMapping("/vehicle/bycategory")
	public List<Vehicle> getVehiclesByCategory(Set<String> models);

}

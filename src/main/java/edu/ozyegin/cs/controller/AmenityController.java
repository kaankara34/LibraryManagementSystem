package edu.ozyegin.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ozyegin.cs.entity.Amenity;
import edu.ozyegin.cs.service.AmenityService;

@RestController
@RequestMapping("amenity")
public class AmenityController {
	
	@Autowired
	AmenityService service;
	
	
	@PostMapping("/create")
	public void createAmenity(String AmenityName, int CallerUserId) {
		
		
	}
	@PostMapping("/modify")
	public void modifyAmenity(String AmenityName,int AmenityId, int CallerUserId) {
		
		
	}
	@PostMapping("/delete")
	public void deleteAmenity(String AmenityName,int AmenityId, int CallerUserId) {
		
		
	}
	@GetMapping("/get_all")
	public List<Amenity> getAllAmenity() {
		
		return service.getAllAmenity();
		
	}

}

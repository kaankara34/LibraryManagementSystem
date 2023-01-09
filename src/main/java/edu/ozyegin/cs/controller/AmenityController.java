package edu.ozyegin.cs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("amenity")
public class AmenityController {
	
	
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
	public void getAllAmenity() {
		
		
	}

}

package edu.ozyegin.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ozyegin.cs.entity.Amenity;
import edu.ozyegin.cs.repository.AmenityRepository;

@Service
public class AmenityService {

	@Autowired
	AmenityRepository repository;

	public List<Amenity> getAllAmenity() {
		return repository.getAllAmenity();
	}
	public  String check_role(int callerId){
		return repository.check_role(callerId);
	}
	public boolean createAmenity(String AmenityName){
		return repository.createAmentiy(AmenityName);
	}
	public boolean modifyAmenity(String AmenityName, int AmenityID){
		return repository.modifyAmenity(AmenityName,AmenityID);
	}

	public boolean deleteAmenity(int amenityId) {
		return repository.deleteAmenity(amenityId);
	}
}

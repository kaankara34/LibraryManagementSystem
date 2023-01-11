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
		return repository.findAll();

	}

}

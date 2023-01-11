package edu.ozyegin.cs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "amenity")
@Entity(name = "amenity")
public class Amenity {


	private int amenityID;
	@Id
	private String amenityName;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "amenityId: " + amenityID + "\n"+"amenityName: " + amenityName;
	}
	
	

}

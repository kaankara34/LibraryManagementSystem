package edu.ozyegin.cs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roomsAmenities")
@Data
public class RoomsAmenities {

	private int roomID;
	private int amenityId;

	/*
	 * PRIMARY KEY(roomID,amenityID), FOREIGN KEY (roomID) REFERENCES rooms(roomID)
	 * ON DELETE CASCADE, FOREIGN KEY (amenityID) REFERENCES amenity(amenityID) ON
	 * DELETE CASCADE
	 */

}

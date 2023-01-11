package edu.ozyegin.cs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "rooms")
@Data
public class Rooms {

	@Id
	private int roomID;
	private int roomTypeID;
	private String room_name;

}

/*
 * PRIMARY KEY (roomID), FOREIGN KEY (roomTypeID) REFERENCES
 * roomType(roomTypeID) ON DELETE SET NULL
 */
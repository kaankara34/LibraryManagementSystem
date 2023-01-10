package edu.ozyegin.cs.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cleaning")
@Data
public class Cleaning {

	private int userID;
	private int roomID;
	private Date cleaning_date;

	/*
	 * PRIMARY KEY (userID,roomID,cleaining_date), FOREIGN KEY (userID) REFERENCES
	 * users(userID) ON DELETE CASCADE, FOREIGN KEY (roomID) REFERENCES
	 * rooms(roomID) ON DELETE CASCADE
	 */

}

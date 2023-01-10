package edu.ozyegin.cs.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="booking")
@Data
public class Booking {
	
	private int userID;
	private int roomID;
	@Id
	private int bookingID;
	private Date start_date;
	private Date end_date;
  
    /*PRIMARY KEY (bookingID),
	FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE SET NULL,
	FOREIGN KEY (roomID) REFERENCES rooms(roomID) ON DELETE SET NULL	*/

}

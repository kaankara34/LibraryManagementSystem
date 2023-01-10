package edu.ozyegin.cs.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="checks")
@Data
public class Checks {
	
	@Id
	private int userID;
	private int roomID;
	private Date check_in;
	private Date check_out;
	
    /*PRIMARY KEY (roomID, check_in),
    FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE SET NULL,
	FOREIGN KEY (roomID) REFERENCES rooms(roomID) ON DELETE cascade*/

}

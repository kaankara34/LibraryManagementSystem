package edu.ozyegin.cs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity(name = "users")
@Data
public class Users {
	@Id
	private int userID;
	private int userTypeID;
	private String user_name;

}

//FOREIGN KEY (userTypeID) REFERENCES userType(userTypeID) ON DELETE SET NULL
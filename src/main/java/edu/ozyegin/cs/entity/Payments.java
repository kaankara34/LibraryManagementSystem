package edu.ozyegin.cs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class Payments {

	@Id
	private int bookingID;
	private int price;
	private boolean paid;

	/*
	 * PRIMARY KEY (bookingID), FOREIGN KEY (bookingID) REFERENCES
	 * booking(bookingID) ON DELETE cascade
	 */
}

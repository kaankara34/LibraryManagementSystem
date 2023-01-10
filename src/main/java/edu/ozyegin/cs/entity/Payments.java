package edu.ozyegin.cs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class Payments {

	private int bookingID;
	private int price;
	private boolean paid;

	/*
	 * PRIMARY KEY (bookingID), FOREIGN KEY (bookingID) REFERENCES
	 * booking(bookingID) ON DELETE cascade
	 */
}

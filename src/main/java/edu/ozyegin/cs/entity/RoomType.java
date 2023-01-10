package edu.ozyegin.cs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "roomtype")
@Entity
@Data
public class RoomType {

	@Id
	private int roomTypeID;
	private String roomTypeName;

}

package edu.ozyegin.cs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "roomtype")
@Entity
@Data
public class RoomType {

	@Id
	private int roomTypeID;
	private String roomTypeName;

}

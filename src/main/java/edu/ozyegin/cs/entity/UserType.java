package edu.ozyegin.cs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "userType")
@Data
public class UserType {

	@Id
	private int userTypeId;
	private String userTypeName;

}

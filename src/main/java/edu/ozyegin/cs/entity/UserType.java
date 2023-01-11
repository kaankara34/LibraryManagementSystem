package edu.ozyegin.cs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "userType")
@Data
public class UserType {

	@Id
	private int userTypeId;
	private String userTypeName;

}

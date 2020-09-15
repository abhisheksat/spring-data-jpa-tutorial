package com.ablive.spring.jpa.jpademo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//	Map it to table - User
@Entity
public class User {

	//	Primary key called id. System generated id values
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String role;

	protected User() {
		super();
	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
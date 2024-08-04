package com.project.entities;

import java.sql.Timestamp;

public class User {
	
	private int id;
	private String nameString;
	private String email;
	private String password;
	private String gender;
	
	private Timestamp dateTimestamp;
	private String profile;

	public User(int id, String nameString, String email, String password, String gender, Timestamp dateTimestamp) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dateTimestamp = dateTimestamp;
	}

	public User() {
		
	}

	public User(String nameString, String email, String password, String gender) {
		super();
		this.nameString = nameString;
		this.email = email;
		this.password = password;
		this.gender = gender;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getDateTimestamp() {
		return dateTimestamp;
	}

	public void setDateTimestamp(Timestamp dateTimestamp) {
		this.dateTimestamp = dateTimestamp;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	
	
}
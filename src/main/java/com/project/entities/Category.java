package com.project.entities;

public class Category {
	private int cid;
	private String name;
	private String Description;
	public Category(int cid, String name, String description) {
		super();
		this.cid = cid;
		this.name = name;
		Description = description;
	}
	public Category() {
		
	}
	public Category(String name, String description) {
		super();
		this.name = name;
		Description = description;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	

}

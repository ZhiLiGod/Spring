package com.zhi.spring.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewCircle {
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public NewCircle(){}
	
	public NewCircle(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "NewCircle [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}

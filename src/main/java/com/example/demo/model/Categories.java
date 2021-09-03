package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="category_id")
	private int id;
	private String name;
	private String description;
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Categories(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}

package com.example.demo.dto;

import java.util.Date;


public class ProductDTO {
	
	private int id;
	private String name;
	private int category_id;
	
	private double price;
	private String description;
	private Date date;
	private String imageName;
	private int vendor_id;
	private int stock;
	private int user_id;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(int id, String name, int category_id, double price, String description, Date date,
			String imageName, int vendor_id, int stock,int user_id) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.price = price;
		this.description = description;
		this.date = date;
		this.imageName = imageName;
		this.vendor_id = vendor_id;
		this.stock = stock;
		this.user_id=user_id;
	}
	public ProductDTO(String name, int category_id, double price, String description, Date date, String imageName,
			int vendor_id, int stock,int user_id) {
		super();
		this.name = name;
		this.category_id = category_id;
		this.price = price;
		this.description = description;
		this.date = date;
		this.imageName = imageName;
		this.vendor_id = vendor_id;
		this.stock = stock;
		this.user_id=user_id;
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", category_id=" + category_id + ", price=" + price
				+ ", description=" + description + ", date=" + date + ", imageName=" + imageName + ", vendor_id="
				+ vendor_id + ", stock=" + stock + ", user_id=" + user_id + "]";
	}
	
	
	
	
}

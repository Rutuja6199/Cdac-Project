package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int myOrderId;
	
	private String orderId;
	private int amount;
	private String recept;
	private String status;
	
	@ManyToOne
	private User user;
	
	private String paymentId;

	public int getMyOrderId() {
		return myOrderId;
	}

	public void setMyOrderId(int myOrderId) {
		this.myOrderId = myOrderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRecept() {
		return recept;
	}

	public void setRecept(String recept) {
		this.recept = recept;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	
}

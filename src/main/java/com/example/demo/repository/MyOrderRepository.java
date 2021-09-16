package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MyOrder;

public interface MyOrderRepository extends JpaRepository<MyOrder, Long> {

	public MyOrder findByOrderId(String orderId);
	
}

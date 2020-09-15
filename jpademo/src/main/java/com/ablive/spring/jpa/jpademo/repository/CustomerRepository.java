package com.ablive.spring.jpa.jpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ablive.spring.jpa.jpademo.dto.OrderJoinResponse;
import com.ablive.spring.jpa.jpademo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT new com.ablive.spring.jpa.jpademo.dto.OrderJoinResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
	public List<OrderJoinResponse> getJoinInformation();
	
}
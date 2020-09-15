package com.ablive.spring.jpa.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ablive.spring.jpa.jpademo.dto.OrderJoinResponse;
import com.ablive.spring.jpa.jpademo.dto.OrderRequest;
import com.ablive.spring.jpa.jpademo.entity.Customer;
import com.ablive.spring.jpa.jpademo.repository.CustomerRepository;
import com.ablive.spring.jpa.jpademo.repository.ProductRepository;

@RestController
public class OrderController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest orderRequest) {
		return customerRepository.save(orderRequest.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/getInfo")
	public List<OrderJoinResponse> getJoinInformation() {
		return customerRepository.getJoinInformation();
	}
	
}
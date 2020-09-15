package com.ablive.spring.jpa.jpademo.dto;

public class OrderJoinResponse {

	private String name;
	private String productName;

	public OrderJoinResponse() {
		super();
	}

	public OrderJoinResponse(String name, String productName) {
		super();
		this.name = name;
		this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "OrderJoinResponse [name=" + name + ", productName=" + productName + "]";
	}

}
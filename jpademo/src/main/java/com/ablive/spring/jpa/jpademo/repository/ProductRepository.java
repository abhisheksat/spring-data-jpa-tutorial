package com.ablive.spring.jpa.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ablive.spring.jpa.jpademo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
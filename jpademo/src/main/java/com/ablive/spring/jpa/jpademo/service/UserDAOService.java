/*
package com.ablive.spring.jpa.jpademo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ablive.spring.jpa.jpademo.entity.User;

@Repository
@Transactional	//	Each method in the class would be transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}
	
}*/
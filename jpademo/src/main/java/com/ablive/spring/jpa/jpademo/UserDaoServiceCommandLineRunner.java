/*
package com.ablive.spring.jpa.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ablive.spring.jpa.jpademo.entity.User;
import com.ablive.spring.jpa.jpademo.service.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDAOService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Bob", "Admin");
		long insert = userDAOService.insert(user);
		logger.info("New user is created: " + user);
	}
}*/
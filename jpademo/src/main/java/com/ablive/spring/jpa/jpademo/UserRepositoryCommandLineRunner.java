/*
package com.ablive.spring.jpa.jpademo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ablive.spring.jpa.jpademo.entity.User;
import com.ablive.spring.jpa.jpademo.repository.UserRepository;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

private static final Logger logger = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jane", "Admin");
		userRepository.save(user);
		logger.info("New user is created: " + user);
		
		Optional<User> userWithIdOne =  userRepository.findById(1L);
		logger.info("User is retrieved: " + userWithIdOne.get());
		
		List<User> users = userRepository.findAll();
		logger.info("All Users: " + users);
	}

}*/
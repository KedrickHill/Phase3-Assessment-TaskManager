package com.project.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.TaskManager.entities.User;
import com.project.TaskManager.exceptions.UserNotFoundException;
import com.project.TaskManager.repositories.TaskRepository;
import com.project.TaskManager.repositories.UserRepository;

public class UserService {

	
	private UserRepository userRepo;
	private TaskRepository taskRepo;
	private BCryptPasswordEncoder bCrypt;
	
	
	@Autowired
	public UserService(UserRepository userRepo, TaskRepository taskRepo, BCryptPasswordEncoder bCrypt) {
		this.userRepo = userRepo;
		this.taskRepo = taskRepo;
		this.bCrypt = bCrypt;
	}

	/**
	 * Collects a user using a name which is checked if the user is empty;
	 * if so, throws Exception
	 * @param name - String
	 * @return - User
	 * @exception - RuntimeException
	 */
	public User GetUserByName(String name) throws UserNotFoundException{ //TODO: eventually change to UNF
		Optional<User> temp = userRepo.findUserByName(name);
		if(!temp.isPresent()) throw new UserNotFoundException();
		return temp.get();
	}
	
	/**
	 * checks the equivalence of a user inputed password and the password for
	 * the user in the DB.
	 * @param jspPass - String: form input
	 * @param dbPass - String: DB 
	 * @return - Boolean
	 */
	public Boolean isValidPassword(String jspPass, String dbPass) {
		return jspPass.equals(dbPass);
	}
}

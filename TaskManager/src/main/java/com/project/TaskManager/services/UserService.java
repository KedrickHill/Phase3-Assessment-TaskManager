package com.project.TaskManager.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TaskManager.controllers.TaskController;
import com.project.TaskManager.entities.User;
import com.project.TaskManager.exceptions.UserNotFoundException;
import com.project.TaskManager.repositories.TaskRepository;
import com.project.TaskManager.repositories.UserRepository;

/**
 * Central hub for all methods that help when working with user information.
 * Adding, removing, and modifying users from the user table in the database
 * @author Kedrick
 *
 */
@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(TaskController.class);

	private UserRepository userRepo;
//	private TaskRepository taskRepo;
	
	
	@Autowired
	public UserService(UserRepository userRepo, TaskRepository taskRepo) {
		this.userRepo = userRepo;
//		this.taskRepo = taskRepo;
	}
	
	/**
	 * Collects all of the users from the database
 	 * @return - List<User>
	 */
	public List<User> GetAllUsers() {
		return userRepo.findAll();
	}

	/**
	 * Collects a user using a name which is checked if the user is empty;
	 * if so, throws Exception
	 * @param name - String
	 * @return - User
	 * @exception - RuntimeException
	 */
	public User GetUserByName(String name) throws UserNotFoundException{ 
		logger.info("Name passed to GetUser: " + name);
		Optional<User> temp = userRepo.findUserByName(name);
//		logger.info("found this user: " + temp.get().getName());
		if(!temp.isPresent()) throw new UserNotFoundException();
		logger.info("Returning found user from sql: " + temp.get().getName());
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
	
	/**
	 * Adds or updates a user to the current repo/DB
	 * @param user - User
	 */
	public void addNewUser(User user) {
		userRepo.save(user);
	}
}

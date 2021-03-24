package com.project.TaskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TaskManager.entities.User;
import com.project.TaskManager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	/**
	 * Collects a user using a name which is checked if the user is empty;
	 * if so, throws Exception
	 * @param name - String
	 * @return - User
	 * @exception - RuntimeException
	 */
	public User GetUserByName(String name) throws RuntimeException{ //TODO: eventually change to UNF
		User temp = (userRepo.findUserByName(name).isPresent()) 
				? userRepo.findUserByName(name).get() : new User();
		if(temp.getName().isEmpty() || temp.getPassword().isEmpty()) throw new RuntimeException();
		return temp;
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

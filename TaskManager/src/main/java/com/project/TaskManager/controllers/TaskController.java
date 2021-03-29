package com.project.TaskManager.controllers;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;
import com.project.TaskManager.services.TaskService;
import com.project.TaskManager.services.UserService;

/**
 * TaskController manages the pathing for the application.
 * @author Kedrick
 *
 */
@Controller
public class TaskController {

	// Global Variables
	Logger logger = LoggerFactory.getLogger(TaskController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	private User authUser;

	/**
	 * Initial landing page
	 * @return - String
	 */
	@GetMapping("/")
	public String login() {
		return "login";
	}

	/**
	 * Post method that takes the form parameters from the login page
	 * and proceeds to authenticate the user by checking the DB
	 * @param username - String
	 * @param password - String
	 * @param model - ModelMap
	 * @return - String
	 */
	@PostMapping("/")
	public String Main(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap model) {
		logger.info("Recieved Username and password: " + username + ": " + password);
		authUser = userService.GetUserByName(username);
		logger.info(authUser.toString());
		if (!userService.isValidPassword(password, authUser.getPassword()))
			return "error";
		String path = (authUser.getRole().equals("USER")) ? "user-main" : "admin-main";
		model.addAttribute("authUser", authUser);
		model.addAttribute("ListOfTasks", taskService.GetAllTasksForUser(authUser));
		return path;
	}

	/**
	 * Used for users that have signed in which redirects to a logout page
	 * @return - String
	 */
	@PostMapping("/logout")
	public String logout() {
		return "logout";
	}
 
	/**
	 * Admin page for adding a task to any user that is in the db
	 * @param model - ModelMap
	 * @param name - String 
	 * @param desc- String
	 * @param sever - String
	 * @param start - Date
	 * @param end - Date
	 * @return - String
	 */
	@PostMapping("/admin-main")
	public String addTask(ModelMap model, @RequestParam String name, @RequestParam String desc, @RequestParam String sever, @RequestParam Date start, @RequestParam Date end) {
		User user = userService.GetUserByName(name);
		Task task = new Task(user, name, sever, desc, start, end);
		taskService.addNewTask(task);
		model.addAttribute("authUser", authUser);
		return "admin-main";
	}
	
	/**
	 * Maps to the Register page to allow for a new user to be registered
	 * @return - String 
	 */
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	/**
	 * Posts the new registered user to the 
	 * DB so they can sign into the application
	 * @param model - ModelMap
	 * @param name - String
	 * @param email -String
	 * @param password - String
	 * @param pswd - String 
	 * @return - String 
	 */
	@PostMapping("/registered")
	public String registered(ModelMap model, @RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String pswd) {
		User tmpUser = new User(name, email, password, "USER");;
		if(password.equals(pswd)) userService.addNewUser(tmpUser);
		model.addAttribute("newUser", tmpUser);
		return "registered";
	}
}

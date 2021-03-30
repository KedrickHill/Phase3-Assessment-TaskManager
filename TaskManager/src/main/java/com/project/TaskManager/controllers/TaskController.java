package com.project.TaskManager.controllers;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;
import com.project.TaskManager.services.TaskService;
import com.project.TaskManager.services.UserService;

/**
 * TaskController manages the pathing for the application.
 * 
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
	private List<Task> allTasks;
	private List<User> allUsers;

	
	/**
	 * ========================================================
	 * = LOGIN SERVLET CONTROLLERS
	 * ========================================================
	 */
	
	/**
	 * Initial landing page
	 * 
	 * @return - String
	 */
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	/**
	 * Post method that takes the form parameters from the login page and proceeds
	 * to authenticate the user by checking the DB
	 * 
	 * @param username - String
	 * @param password - String
	 * @param model    - ModelMap
	 * @return - String
	 */
	@PostMapping("/user-main")
	public ModelAndView Main(@RequestParam("username") String username, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		logger.info("Recieved Username and password: " + username + " : " + password);
		authUser = userService.GetUserByName(username);
		logger.info(authUser.toString());
		if (!userService.isValidPassword(password, authUser.getPassword()))
			return new ModelAndView("error");
		logger.info("Login Successful");
		mv.addObject("authUser", authUser);
		mv.addObject("ListOfTasks", taskService.GetAllTasksForUser(authUser));
//		model.addAttribute("authUser", authUser);
//		model.addAttribute("ListOfTasks", taskService.GetAllTasksForUser(authUser));
		logger.info("Redirecting to user-main...");
		mv.setViewName("user-main");
		return mv;
	}

	/**
	 * ========================================================
	 * = LOGOUT SERVLET CONTROLLER
	 * ========================================================
	 */
	/**
	 * Used for users that have signed in which redirects to a logout page
	 * 
	 * @return - String
	 */
	@PostMapping("/logout")
	public ModelAndView logout() {
		return new ModelAndView("logout");
	}

	/**
	 * ========================================================
	 * = USER MAIN / UPDATE SERVLET CONTROLLERS
	 * ========================================================
	 */
	
	/**
	 * 
	 * @param ListOfTasks
	 * @return
	 */
	@GetMapping("/user-main")
	public ModelAndView showUserMain() {
		return new ModelAndView("user-main");
	}
	
	/*
	 *  
	 */
	//TODO: This is optional to complete
	@PostMapping("user-main/update")
	public ModelAndView saveTask(@RequestParam List<Task> ListOfTasks) {
		ModelAndView mv = new ModelAndView();
		logger.info(ListOfTasks.get(0).toString());
		mv.addObject("authUser", authUser);
		mv.addObject("ListOfTasks", taskService.GetAllTasksForUser(authUser));
		mv.setViewName("redirect:user-main");
		return mv;
	} 

	/**
	 * ========================================================
	 * = ADMIN LOGIN SERVLET CONTROLLERS
	 * ========================================================
	 */
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/adminlogin")
	public ModelAndView showAdminLoginPage() {
		return new ModelAndView("adminlogin");
	}

	

	/**
	 * ========================================================
	 * = ADMIN MAIN SERVLET CONTROLLER
	 * ========================================================
	 */
	
	@GetMapping("/admin-main") 
	public ModelAndView showAdminMain() {
		return new ModelAndView("admin-main");
	}
	
	/**
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 */
	//TODO: Get this working so admins can sign into the admin page
	@PostMapping("/admin-main")
	public ModelAndView adminMain(@RequestParam String username, @RequestParam String password) {
		logger.info("Recieved Username and password: " + username + ": " + password);
		ModelAndView mv = new ModelAndView();
		authUser = userService.GetUserByName(username);
		logger.info(authUser.toString());
		if (!userService.isValidPassword(password, authUser.getPassword()) || !authUser.getRole().equals("ADMIN"))
			return new ModelAndView("error");
		logger.info("Login Successful");
		mv.addObject("authUser", authUser);
		mv.addObject("ListOfTasks", taskService.GetAllTasksForUser(authUser));
		mv.addObject("allTasks", allTasks);
		mv.addObject("allUsers", allUsers);
//		model.addAttribute("authUser", authUser);
//		model.addAttribute("ListOfTasks", taskService.GetAllTasksForUser(authUser));
//		model.addAttribute("allTasks", allTasks);
//		model.addAttribute("allUsers", allUsers);
		logger.info("Redirecting to /admin-main...");
		mv.setViewName("admin-main");
		return mv;

	}
	
	/**
	 * Admin page for adding a task to any user that is in the db
	 * 
	 * @param model - ModelMap
	 * @param name  - String
	 * @param desc - String
	 * @param sever - String
	 * @param start - Date
	 * @param end   - Date
	 * @return - String
	 */
	//TODO: ensure that an admin can still add a task to a user
	@PostMapping("/admin-main/addTask")
	public String addTask(ModelMap model, @RequestParam String name, @RequestParam String taskName,
			@RequestParam String desc, @RequestParam String sever, @RequestParam Date start, @RequestParam Date end) {
		User user = userService.GetUserByName(name);
		Task task = new Task(user, taskName, sever, desc, start, end);
		taskService.addUpdateNewTask(task);
		model.addAttribute("authUser", authUser);
		model.addAttribute("allTasks", allTasks = taskService.GetAllTasks());
		model.addAttribute("allUsers", allUsers = userService.GetAllUsers());
		return "admin-main";
	}
	
	/**
	 * ========================================================
	 * = USER REGISTRATION SERVLET CONTROLLERS
	 * ========================================================
	 */

	/**
	 * Maps to the Register page to allow for a new user to be registered
	 * 
	 * @return - String
	 */
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	/**
	 * Posts the new registered user to the DB so they can sign into the application
	 * 
	 * @param model    - ModelMap
	 * @param name     - String
	 * @param email    - String
	 * @param password - String
	 * @param pswd     - String
	 * @return - String
	 */
	@PostMapping("/registered")
	public ModelAndView registered(ModelMap model, @RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String pswd) {
		User tmpUser = new User(name, email, password, "USER");
		;
		if (!password.equals(pswd))
			return new ModelAndView("error");
		userService.addNewUser(tmpUser);
		model.addAttribute("newUser", tmpUser);
		return new ModelAndView("registered");
	}
}

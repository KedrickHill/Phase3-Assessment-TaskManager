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

@Controller
public class TaskController {

	Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;
	
	private User authUser;

	@GetMapping("/")
	public String login() {
		return "login";
	}

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
		return path;
	}

	@PostMapping("/logout")
	public String logout() {
		return "logout";
	}
 
	@PostMapping("/admin-main")
	public String addTask(ModelMap model, @RequestParam String name, @RequestParam String desc, @RequestParam String sever, @RequestParam Date start, @RequestParam Date end) {
		User user = userService.GetUserByName(name);
		Task task = new Task(user, sever, desc, start, end);
		taskService.addNewTask(task);
		model.addAttribute("authUser", authUser);
		return "admin-main";
	}
}

package com.project.TaskManager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.TaskManager.entities.User;
import com.project.TaskManager.services.UserService;

@Controller
public class TaskController {

	Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private UserService userService;
//	private TaskService taskService;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
//	@PostMapping("/user-main")
//	public String userMain() {
//		return "user-main";
//	}

	@PostMapping("/")
	public String Main(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model) {
		logger.info("Recieved Username and password: " + username + ": " + password);
		User user = userService.GetUserByName(username);
		logger.info(user.toString());
		String path = (userService.isValidPassword(password, user.getPassword())) ? "user-main" : "login?error=true";
		model.addAttribute("authUser", user);
		return path;
	}
	@PostMapping("/logout")
	public String logout() {
		return "logout";
	}
}
 
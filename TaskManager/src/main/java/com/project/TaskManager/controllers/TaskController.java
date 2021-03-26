package com.project.TaskManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

	@GetMapping(value={ "/", "/login"})
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/login");
		return model;
	}
//	@PostMapping("/user-main")
//	public String userMain() {
//		return "user-main";
//	}

	@PostMapping(value= {"/","/login"})
	public ModelAndView Main() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user-main");
		return model;
	}
//	@PostMapping("/user-main")
//	public ModelAndView 
}

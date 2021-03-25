package com.project.TaskManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

	@GetMapping({ "/", "/login"})
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@GetMapping("/user-main")
	public ModelAndView Main() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user-main");
		return model;
	}
}

package com.project.TaskManager.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;
import com.project.TaskManager.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	/**
	 * Collects all tasks from the DB.
	 * @return - All Tasks from SQL
	 */
	public Iterable<Task> GetAllTasks() {
		return taskRepo.findAll();
	}
	
	/**
	 * Collects all tasks under a specified user
	 * @param user - User
	 * @return - Iterable of task connected to param user
	 * @exception - RuntimeException
	 */
	public Iterable<Task> GetAllTasksForUser(User user) throws RuntimeException{ //TODO: eventually change to UNF
		return taskRepo.findAllByUser(user);
	}
	
	/**
	 * Collects all tasks that start by the given time
	 * @param start - Date
	 * @return - Iterable of all tasks connected to param start
	 */
	public Iterable<Task> GetAllTasksByStart(Date start) {
		return taskRepo.findAllByStart(start);
	}
	
	/**
	 * Collects all tasks that based on serverity
	 * @param sever - String
	 * @return - Iterable of all task connected to param sever
	 */
	public Iterable<Task> GetAllTasksBySeverity(String sever) {
		return taskRepo.findAllBySeverity(sever);
	}
}

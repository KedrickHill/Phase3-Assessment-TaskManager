package com.project.TaskManager.services;

import java.sql.Date;
import java.util.List;

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
	 * @return - List of task connected to param user
	 * @exception - RuntimeException
	 */
	public List<Task> GetAllTasksByUser(User user) throws RuntimeException{ //TODO: eventually change to UNF
		return taskRepo.findAllTasksForUser(user);
	}
	
	/**
	 * Collects all tasks that start by the given time
	 * @param start - Date
	 * @return - List of all tasks connected to param start
	 */
	public List<Task> GetAllTasksByStart(Date start) {
		return taskRepo.findAllTasksByStart(start);
	}
	
	/**
	 * Collects all tasks that based on serverity
	 * @param sever - String
	 * @return - List of all task connected to param sever
	 */
	public List<Task> GetAllTasksBySeverity(String sever) {
		return taskRepo.findAllTasksBySeverity(sever);
	}
}
package com.project.TaskManager.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;
import com.project.TaskManager.exceptions.UserNotFoundException;
import com.project.TaskManager.repositories.TaskRepository;

/**
 * TaskService is central hub for all methods that aide in adding,
 * collecting, updating, and removing tasks from the task table in
 * the database.
 * @author Kedrick
 *
 */
@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	/**
	 * Collects all tasks from the DB.
	 * @return - List of all Tasks from SQL
	 */
	public List<Task> GetAllTasks() {
		return taskRepo.findAll();
	}
	
	/**
	 * Collects all tasks under a specified user
	 * @param user - User
	 * @return - List of task connected to param user
	 * @exception - RuntimeException
	 */
	public List<Task> GetAllTasksForUser(User user) throws UserNotFoundException{ //TODO: eventually change to UNF
		return taskRepo.findAllByUser(user);
	}
	
	/**
	 * Collects all tasks that start by the given time
	 * @param start - Date
	 * @return - List of all tasks connected to param start
	 */
	public List<Task> GetAllTasksByStart(Date start) {
		return taskRepo.findAllByStart(start);
	}
	
	/**
	 * Collects all tasks that based on serverity
	 * @param sever - String
	 * @return - List of all task connected to param sever
	 */
	public List<Task> GetAllTasksBySeverity(String sever) {
		return taskRepo.findAllBySeverity(sever);
	}
	
	/**
	 * Collects all tasks that are labeled by the same task name keyword(s)
	 * @param name - String 
	 * @return - List<Task>
	 */
	public List<Task> GetAllByTaskName(String name) {
		return taskRepo.findAllByTaskName(name);
	}
	
	/**
	 * Adds and updates a task to the list of tasks
	 * @param task - Task
	 */
	public void addUpdateNewTask(Task task) {
		taskRepo.save(task);
	}
}

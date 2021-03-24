package com.project.TaskManager.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	public List<Task> findAllTasksForUser(User user);
	public Task findTaskByStart(Date date);
	public Task findAllTasksBySeverity(String sever);
}

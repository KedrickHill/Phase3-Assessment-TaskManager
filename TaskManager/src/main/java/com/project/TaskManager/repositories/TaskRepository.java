package com.project.TaskManager.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

	public List<Task> findAllTasksForUser(User user);
	public List<Task> findAllTasksByStart(Date date);
	public List<Task> findAllTasksBySeverity(String sever);
}

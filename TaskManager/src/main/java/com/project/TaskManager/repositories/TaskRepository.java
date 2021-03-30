package com.project.TaskManager.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	public List<Task> findAllByUser(User user);
	public List<Task> findAllByStart(Date date);
	public List<Task> findAllBySeverity(String sever);
	public List<Task> findAllByName(String taskName);
	public Task findTaskByDescription(String description);
}

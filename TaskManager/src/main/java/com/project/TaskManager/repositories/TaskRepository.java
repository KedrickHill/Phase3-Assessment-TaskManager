package com.project.TaskManager.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TaskManager.entities.Task;
import com.project.TaskManager.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	public Iterable<Task> findAllByUser(User user);
	public Iterable<Task> findAllByStart(Date date);
	public Iterable<Task> findAllBySeverity(String sever);
	//TODO: should there be ways to search tasks by all types of a task?
}

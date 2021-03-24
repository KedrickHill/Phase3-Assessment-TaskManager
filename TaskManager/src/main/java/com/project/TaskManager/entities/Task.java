package com.project.TaskManager.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="task")

public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@NotNull private Integer id;
	private String name;
	private String email;
	private String severity;
	private String description;
	private Date start;
	private Date end;
	
	@ManyToOne
	private User user;
	
	public Task() {
		super();
	}
	
	public Task(String name, String email, String severity, String description, Date start) {
		super();
		this.name = name;
		this.email = email;
		this.severity = severity;
		this.description = description;
		this.start = new Date(System.currentTimeMillis());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

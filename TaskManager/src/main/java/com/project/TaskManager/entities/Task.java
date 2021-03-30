package com.project.TaskManager.entities;

import java.sql.Date;

import javax.persistence.Column;
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
	@Column(name="id")
	@NotNull private Integer id;
	@Column(name="task_name")
	@NotNull private String name;
	@Column(name="severity")
	@NotNull private String severity;
	@Column(name="description")
	@NotNull private String description;
	@Column(name="start_date")
	@NotNull private Date start;
	@Column(name="end_date")
	@NotNull private Date end;
	@Column(name="is_complete")
	private boolean isComplete;
	
	@ManyToOne
	private User user;
	
	public Task() {
		super();
	}
	
	public Task(User user, String name, String severity, String description, Date start, Date end) {
		super();
		this.user = user;
		this.name = name;
		this.severity = severity;
		this.description = description;
		this.start = start;
		this.end = end;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", severity=" + severity + ", description=" + description + ", start=" + start
				+ ", end=" + end + ", isComplete=" + isComplete + "]";
	}
	
	
}

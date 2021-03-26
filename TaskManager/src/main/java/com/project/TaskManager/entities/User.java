package com.project.TaskManager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull private Integer id;
	@Column(name="name")
	@NotNull private String name;
	@Column(name="email")
	@NotNull private String email;
	@Column(name="password")
	@NotNull private String password;
	@Column(name="role")//TODO: Add roles to help define task management? Admin and User? Admin can set info for a user?
	@NotNull private String role;
	
	public User() {
		super();
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) { //TODO: should users be allowed to set their password? perhaps if they are admin they can?
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

	
	
}

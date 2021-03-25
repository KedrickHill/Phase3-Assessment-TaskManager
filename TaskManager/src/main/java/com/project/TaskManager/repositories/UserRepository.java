package com.project.TaskManager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TaskManager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findUserByName(String name);
}

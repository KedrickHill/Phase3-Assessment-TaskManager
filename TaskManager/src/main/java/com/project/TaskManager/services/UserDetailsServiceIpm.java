package com.project.TaskManager.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.TaskManager.WebSecurityConfig;
import com.project.TaskManager.entities.MyUserDetails;
import com.project.TaskManager.entities.User;

@Service
public class UserDetailsServiceIpm implements UserDetailsService{

	Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	private UserService userService;

	/**
	 * Loads a user from the database and returns it as a UserDetails object when logging in
	 * @param - String: name of user
	 * @return - UserDetails: authorized user
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Username that is being passed to loadUserByUsername is : " + username);
		
		User user = userService.GetUserByName(username);
		
		logger.info("User Credentials collected from sql: " + user.toString());
		
		
		return new MyUserDetails(userService.GetUserByName(username));
	}
	
}

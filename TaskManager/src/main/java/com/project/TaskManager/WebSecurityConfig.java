//package com.project.TaskManager;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	UserDetailsService userDetailsService;
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/login").permitAll()
//				.antMatchers("/user-main").hasAuthority("USER")
//				.antMatchers("/admin/**").hasAuthority("ADMIN")
//				.anyRequest().authenticated()
//				.and()
//					.csrf()
//					.disable()
//				.formLogin()
//				.loginPage("/login")
//				.defaultSuccessUrl("/user-main")
//				.failureUrl("/login?error=true")
//				.usernameParameter("username")
//				.passwordParameter("password")
//				.permitAll()
//			.and()
//				.logout()
//				.logoutSuccessUrl("/login?logout=true")
//				.invalidateHttpSession(true);
//			
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**","/css/**", "/js/**","/images/**");
//	}
//}

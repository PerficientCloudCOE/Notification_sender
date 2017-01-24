package com.perficient.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.perficient.dao.GroupDAO;
import com.perficient.dao.LoginDAO;
import com.perficient.dao.MemberDAO;
import com.perficient.dao.MessageDAO;
import com.perficient.dao.RegisterDAO;
import com.perficient.dao.UserDAO;

@Configuration
public class WebConfig {
	@Bean
	public SessionFactory getSessionFactory() {
		SessionFactory factory = null;
		if (factory == null)
			factory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
		return factory;
	}

	@Bean
	public RegisterDAO getRegister() {
		return new RegisterDAO();
	}

	@Bean
	public UserDAO getUser() {
		return new UserDAO();
	}

	@Bean
	public LoginDAO getLogin() {
		return new LoginDAO();
	}

	@Bean
	public GroupDAO getGroup() {
		return new GroupDAO();
	}

	@Bean
	public MemberDAO getMember() {
		return new MemberDAO();
	}
	
	@Bean
	public MessageDAO getMessage() {
		return new MessageDAO();
	}
}

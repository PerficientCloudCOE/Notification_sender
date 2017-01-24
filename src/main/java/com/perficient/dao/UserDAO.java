package com.perficient.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.domain.User;
import com.perficient.domain.UserAccess;

public class UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	

	public Object findUser(String userName, String password) {
		int userID = findUserID(userName);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserAccess.class);
		criteria.add(Restrictions.eq("userId", userID));
		criteria.add(Restrictions.eq("password", password));
		Object userList = criteria.list();
		session.close();
		return userList;
	}
	
	public int findUserID(String userName){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userName));
		List userList = criteria.list();
		session.close();
		int userId = 0;
		if(userList.size()>0){
			for(Object us : userList){
				User user = (User) us;
				userId = user.getId();
			}
		}
		return userId;
	}

	public String getUserMailId(String userName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userName));
		List userList = criteria.list();
		session.close();
		String userMailId = "";
		if(userList.size()>0){
			for(Object us : userList){
				User user = (User) us;
				userMailId = user.getEmail();
			}
		}
		return userMailId;
	}
}

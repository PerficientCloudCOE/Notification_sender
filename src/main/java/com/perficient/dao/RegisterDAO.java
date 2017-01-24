package com.perficient.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.domain.User;
import com.perficient.domain.UserAccess;

public class RegisterDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public void addUserDetails(String userName,String password,String email
			,String firstname,String lastname,String role,String date){
		Transaction transaction = null;
		Session session = null;
		try{
						
			session=sessionFactory.openSession();
			transaction =session.beginTransaction();
			
			User register=new User();
			register.setUserId(userName);
			
			register.setEmail(email);
			register.setFirstname(firstname);
			register.setLastname(lastname);
			register.setRole(role);
			register.setCreation_date(date);
			
			UserAccess userAccess = new UserAccess();
			userAccess.setPassword(password);
			userAccess.setUser(register);
			session.save(userAccess);
			transaction.commit();
			session.close();
			
			System.out.println("\n\n User Details are Saved!!! \n"+ userName);
		}catch (HibernateException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			//roll back on failure
			transaction.rollback();
			session.close();
			System.out.println("error");
		}
	}
}

package com.perficient.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.domain.Message;

public class MessageDAO {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * this method will be used to persist Message
	 */
	public void persistMessage(Message msg) {
		Session ses = null;
		Transaction tx = null;
		ses = sessionFactory.openSession();
		tx = ses.beginTransaction();
		ses.save(msg);
		tx.commit();
		ses.close();
	}
}

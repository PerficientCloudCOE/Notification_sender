package com.perficient.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.domain.Member;

public class MemberDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	/*
	 * this method will be used to persist member
	 */
	public void persistMember(Member member) {
		Session ses = null;
		Transaction tx = null;
		ses = sessionFactory.openSession();
		tx = ses.beginTransaction();
		ses.save(member);
		tx.commit();
		ses.close();
	}
}

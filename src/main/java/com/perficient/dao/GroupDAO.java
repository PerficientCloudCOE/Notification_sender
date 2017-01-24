package com.perficient.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.domain.Group;

public class GroupDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<Group> listGroup() {
		Session session = sessionFactory.openSession();
		List<Group> groupList = session.createCriteria(Group.class).list();
		session.close();
		return groupList;
	}

	public Map<Integer, Group> groupsAsMap() {
		Map<Integer, Group> map = new HashMap<Integer, Group>();
		// Fetch list of groups
		List<Group> allGroups = listGroup();
		for(Group g: allGroups){
			map.put(g.getGroupId(), g);
		}
		return map;
	}
}
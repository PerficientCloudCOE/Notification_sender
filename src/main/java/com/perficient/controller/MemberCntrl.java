package com.perficient.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.dao.GroupDAO;
import com.perficient.dao.MemberDAO;
import com.perficient.domain.Group;
import com.perficient.domain.Member;

@Controller
public class MemberCntrl {

	@Autowired
	private MemberDAO memberDao;
	@Autowired
	private GroupDAO groupDao;

	@RequestMapping("/addMember.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
		int groupId = Integer.parseInt(request.getParameter("groups"));
		String firstName = request.getParameter("firstname");
		String lastName= request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobNo= request.getParameter("mobNo");
		
		//this is to incorporate manytoMany mapping in the future
		Map<Integer, Group> map = groupDao.groupsAsMap();
		Set<Group> groups = new HashSet<Group>();
		groups.add(map.get(groupId));
		
		Member member = new Member();
		member.setGroups(groups);//add a bunch of group here
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setEmail(email);
		member.setMobileNo(mobNo);
		
		memberDao.persistMember(member);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("group", Group.class);
		model.put("listGroups", getGroupDao().listGroup());
		
		return new ModelAndView("resultPage", "msg" ,model);
	}

	public MemberDAO getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public GroupDAO getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}
}

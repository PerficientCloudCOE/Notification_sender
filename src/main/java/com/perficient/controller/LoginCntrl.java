package com.perficient.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.dao.GroupDAO;
import com.perficient.dao.LoginDAO;
import com.perficient.domain.Group;

@Controller
@SessionAttributes("myRequestObject")
public class LoginCntrl{
	
	@Autowired
	private LoginDAO LoginDao;
	@Autowired
	private GroupDAO groupDao;
	
	@RequestMapping("/login.do")
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
		HttpSession session = request.getSession();
		String userName = request.getParameter("txtUserName");
		String password= request.getParameter("txtPassword");
		session.setAttribute("UserName", userName);
		session.setAttribute("Password", password);
		Map<String, Object> model = new HashMap<String, Object>();
		ArrayList credentials = (ArrayList) LoginDao.findUser(userName, password);
		if(credentials.size()>0){
			model.put("group", Group.class);
			request.getSession().setAttribute("listGroups", groupDao.listGroup());
			model.put("listGroups", groupDao.listGroup());
			return new ModelAndView("resultPage", "msg", model); 
		}
		else{
			model.put("msg", "Invalid User");
			return new ModelAndView("Login");
		}
	}
	
}

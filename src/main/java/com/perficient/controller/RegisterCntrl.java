package com.perficient.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.dao.RegisterDAO;


@Controller
public class RegisterCntrl{
	
	@Autowired
	private RegisterDAO RegisterDao;

	@RequestMapping("/register.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
	
		SimpleDateFormat sdfDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password1"); // fetches the value in confirm password field
		String email=request.getParameter("email");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String role=request.getParameter("role");
		String date= sdfDate.format(now);
		
		RegisterDao.addUserDetails(userName, password, email, firstname, lastname, role, date);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", "Registeration Successfull");
		return new ModelAndView("Success", "msg", model);
	}
}

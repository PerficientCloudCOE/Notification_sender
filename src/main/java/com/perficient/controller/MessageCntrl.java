package com.perficient.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perficient.action.PublishMessageAction;
import com.perficient.dao.GroupDAO;
import com.perficient.dao.MessageDAO;
import com.perficient.dao.UserDAO;
import com.perficient.domain.Group;
import com.perficient.domain.Message;

@Controller
public class MessageCntrl {
	@Autowired
	private GroupDAO groupDao;

	@Autowired
	private MessageDAO messageDao;

	@Autowired
	private UserDAO userDao;

	@Autowired
	PublishMessageAction publishMessageAction;

	@RequestMapping("/createMsg.do")
	public ModelAndView createMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("UserName");
		System.out.println("UserName = " + userName);
		String groups[] = request.getParameterValues("groupChBox");
		session.setAttribute("groups", groups);

		if (groups != null) {
			System.out.println("groups are: ");
			for (String group : groups) {
				System.out.println("\t" + group);
			}
		}

		return new ModelAndView("CreateMsgPage");
	}

	@RequestMapping("/msgMerge.do")
	public ModelAndView sendMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String msgContent = request.getParameter("txtMsg");
		String groups[] = (String[]) session.getAttribute("groups");
		String groupList = "";

		// gets the individual group names from a comma separated string of
		// groups
		if (groups != null) {
			System.out.println("groups are: ");
			for (String group : groups) {
				if (groupList.equals(""))
					groupList = group;
				else
					groupList = groupList + " , " + group;
				System.out.println("\t" + groupList);
			}
		}

		// Message creation
		Message msg = new Message();
		msg.setMessage(msgContent);
		msg.setGroupIdList(groupList);
		msg.setStatus("Sent");
		msg.setMailId(userDao.getUserMailId((String) session.getAttribute("UserName")));

		// Saves message to DB
		messageDao.persistMessage(msg);
		System.out.println(msg.getId() + "Saved");

		// Publishes message to MQ
		String result = publishMessageAction.publishMessageToQueue(msg);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", result);
		model.put("group", Group.class);
		model.put("listGroups", groupDao.listGroup());

		return new ModelAndView("resultPage", "msg", model);
	}
}

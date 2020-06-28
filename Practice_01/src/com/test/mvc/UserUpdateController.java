package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserUpdateController implements Controller
{
	private IUserDAO dao;
	
	public void setDao(IUserDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String jobId = request.getParameter("jobId");
		
		User user = new User();
		user.setJobId(jobId);
		user.setUserName(userName);
		user.setUserBirth(userBirth);
		user.setUserId(userId);
		try
		{
			dao.modify(user);
			mav.setViewName("redirect:userlist.action");
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}

}

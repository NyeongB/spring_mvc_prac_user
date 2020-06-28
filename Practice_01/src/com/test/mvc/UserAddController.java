package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserAddController implements Controller
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
		//System.out.println("11111111111");
		//System.out.println(request.getParameter("userName"));
		///System.out.println(request.getParameter("jobId"));
		//System.out.println(request.getParameter("userBirth"));
		
		//request.getParameter("");
		
		
		try
		{
			User user = new User();
			
			user.setJobId(request.getParameter("jobId"));
			user.setUserName(request.getParameter("userName"));
			user.setUserBirth(request.getParameter("userBirth"));
			user.setUserId(request.getParameter("userId"));
			
			dao.add(user);
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		mav.setViewName("redirect:userlist.action");
		return mav;
	}

}

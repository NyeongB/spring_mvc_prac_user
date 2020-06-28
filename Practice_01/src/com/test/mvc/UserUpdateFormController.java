package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserUpdateFormController implements Controller
{
	private IJobDAO jobDao;
	private IUserDAO dao;
	
	public void setJobDao(IJobDAO jobDao)
	{
		this.jobDao = jobDao;
	}
	
	public void setDao(IUserDAO dao)
	{
		this.dao = dao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String userId = request.getParameter("userId");
		//System.out.println(userId);
		//System.out.println("11111");
		ModelAndView mav = new ModelAndView();
		User user = new User();
		ArrayList<Job> jobList = new ArrayList<Job>();
		
		
		try
		{
			user = dao.searchId(Integer.parseInt(userId));
			jobList = jobDao.list();
			
			mav.addObject("user",user);
			mav.addObject("jobList",jobList);
			
			mav.setViewName("UserUpdateForm");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return mav;
	}

}

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserListController implements Controller
{
	private IUserDAO dao;
	
	public void setDao(IUserDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//System.out.println("UserListController.java 실행");
		ModelAndView mav = new ModelAndView();
		ArrayList<User> userList = new ArrayList<User>();
		
		try
		{
			userList = dao.list();
			mav.addObject("userList", userList);
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		mav.setViewName("UserList");
		
		return mav;
	}

}

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserDeleteController implements Controller
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
		try
		{
			int result = dao.remove(Integer.parseInt(userId));
			if(result>0)
				System.out.println("삭제 완료~!!");
			
			mav.setViewName("redirect:userlist.action");
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		
		return mav;
	}

}

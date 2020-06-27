package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserAddFormController implements Controller
{
	private IJobDAO jobDao;
	
	public void setJobDao(IJobDAO jobDao)
	{
		this.jobDao = jobDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		ArrayList<Job> jobList = new ArrayList<Job>();
		try
		{
			jobList = jobDao.list();
			mav.addObject("jobList",jobList);
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		//System.out.println("1111111111111111111");
		//System.out.println(jobList.get(3).getJobName());
		//System.out.println(jobList.size());
		mav.setViewName("UserAddForm");

		return mav;
	}

}

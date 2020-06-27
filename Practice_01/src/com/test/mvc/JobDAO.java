package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class JobDAO implements IJobDAO
{
	private DataSource dataSource;
	
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}


	@Override
	public ArrayList<Job> list() throws SQLException
	{
		ArrayList<Job> result = new ArrayList<Job>();
		
		Connection conn = dataSource.getConnection();
		
		String sql ="SELECT JOBID, JOBNAME FROM TBL_JOBS";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			Job job = new Job();
			job.setJobId(rs.getString("JOBID"));
			job.setJobName(rs.getString("JOBNAME"));
			result.add(job);
		}
		//System.out.println("레절트크기"+result.size());
		conn.close();
		pstmt.close();
		rs.close();
		
		return result;
	}

}

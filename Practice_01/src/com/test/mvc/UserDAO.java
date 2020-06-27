package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class UserDAO implements IUserDAO
{
	private DataSource dataSource;
	
	

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<User> list() throws SQLException
	{
		ArrayList<User> result = new ArrayList<User>();
		Connection conn = dataSource.getConnection();
		String sql = "SELECT USERID, USERNAME, USERAGE, JOBNAME FROM VIEW_USER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			User user = new User();
			user.setUserId(rs.getString("USERID"));
			user.setUserName(rs.getString("USERNAME"));
			user.setUserAge(rs.getString("USERAGE"));
			user.setJobName(rs.getString("JOBNAME"));
			
			result.add(user);
		}
		rs.close();
		conn.close();
		pstmt.close();
		
		return result;
	}

	@Override
	public int add(User user) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(User user) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int userId) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

}

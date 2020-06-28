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
		String sql = "SELECT USERID, USERNAME, USERAGE, JOBNAME, JOBID FROM VIEW_USER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			User user = new User();
			user.setUserId(rs.getString("USERID"));
			user.setUserName(rs.getString("USERNAME"));
			user.setUserAge(rs.getString("USERAGE"));
			user.setJobName(rs.getString("JOBNAME"));
			user.setJobId(rs.getString("JOBID"));
			
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
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		String sql = "INSERT INTO TBL_USER(USERID, USERNAME, USERBIRTH, JOBID)"
				+ " VALUES(USER_SEQ.NEXTVAL, ?,"
				+ " TO_DATE(?, 'YYYY-MM-DD'),?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserBirth());
		pstmt.setString(3, user.getJobId());
		result = pstmt.executeUpdate();
		
		return result;
	}

	@Override
	public int modify(User user) throws SQLException
	{
		int result = 0;
		System.out.println("////////////");
		System.out.println(user.getUserName());
		System.out.println(user.getUserBirth());
		System.out.println(user.getJobId());
		System.out.println(user.getUserId());
		
		Connection conn = dataSource.getConnection();
		String sql = "UPDATE TBL_USER SET USERNAME =?,"
				+ " USERBIRTH = ?, JOBID = ? WHERE USERID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserBirth());
		pstmt.setString(3, user.getJobId());
		pstmt.setString(4, user.getUserId());
		
		result  = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	

	@Override
	public int remove(int userId) throws SQLException
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		String sql = "DELETE FROM TBL_USER WHERE USERID =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public User searchId(int userId) throws SQLException
	{
		User result = new User();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT USERID, USERNAME, JOBID, USERBIRTH FROM VIEW_USER WHERE USERID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			System.out.println((rs.getString("JOBID")));
			
			
			result.setUserBirth(rs.getString("USERBIRTH"));
			result.setUserId(rs.getString("USERID"));
			result.setUserName(rs.getString("USERNAME"));
			result.setJobId(rs.getString("JOBID"));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

}

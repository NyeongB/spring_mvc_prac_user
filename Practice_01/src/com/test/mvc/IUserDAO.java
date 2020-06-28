package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUserDAO
{
	public ArrayList<User> list() throws SQLException;
	public int add(User user) throws SQLException;
	public int modify(User user) throws SQLException;
	public int remove(int userId) throws SQLException;
	public User searchId(int userId) throws SQLException;
}

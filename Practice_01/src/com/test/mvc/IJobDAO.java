package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IJobDAO
{
	public ArrayList<Job> list() throws SQLException;
}

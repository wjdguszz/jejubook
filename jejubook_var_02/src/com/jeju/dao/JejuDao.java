package com.jeju.dao;

import java.io.IOException;

public interface JejuDao {

	String insertSql = "INSERT INTO JEJU VALUES(?,?,?,?,?,?,?,?,?)";
	
	public void beachInsert() throws IOException;
	public void gallary() throws IOException;
	public void stay() throws IOException;
	public void foodInsert() throws IOException;
}

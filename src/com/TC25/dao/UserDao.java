package com.TC25.dao;

import java.sql.SQLException;

import com.TC25.bean.User;

//--数据库操作. 增删改查代码是写在这里的.

public interface UserDao {

	/**
	 * 根据用户账户获取User对象.(从数据库中查询出来的.)
	 * @param userAccount
	 * @return
	 * @throws SQLException 
	 */
	public User getUserByUserAcc(String userAcc) throws SQLException;

	public boolean isUserAccExist(String userAcc) throws SQLException;
	
	public boolean addUserToDataBase(User u) throws SQLException;
}















package com.TC25.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.TC25.bean.User;
import com.TC25.dao.UserDao;
import com.TC25.tools.DBHelper;

public class UserDaoImpl implements UserDao {
	
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	
	private DBHelper mDB;
	public UserDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}
	

	//Ctrl + 1
	@Override
	public User getUserByUserAcc(String userAcc) throws SQLException {
	
		//--问号叫做占位符.
		String sql = "select * from UserList where userAcc = ?";
		
		//--通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);
		
		//--通过PreparedStatement对象给占位符做赋值操作
		mStatement.setString(1, userAcc);
		
		//--通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		//executeQuery  是查询专用
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
		 */
		rSet = mStatement.executeQuery();
		if (rSet == null) {
			return null;
		}
		User u = new User();
		while (rSet.next()) {			
			u.setUserId(rSet.getInt("USERID"));	
			u.setUserAcc(rSet.getString("USERACC"));
			u.setUserName(rSet.getString("USERNAME"));	
			u.setUserPwd(rSet.getString("USERPWD"));
			u.setUserPwdTip(rSet.getString("USERPWDTIP"));
			u.setUserStatus(rSet.getInt("USERSTATUS"));
		}		
		return u;
	}


	@Override
	public boolean isUserAccExist(String userAcc) throws SQLException {
		String sql = "select * from UserList where userAcc = ?";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, userAcc);
		rSet = mStatement.executeQuery();
		if (rSet == null) {
			return true;
		}
		return false;
	}

}














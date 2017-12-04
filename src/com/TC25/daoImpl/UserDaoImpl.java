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
	
		//--�ʺŽ���ռλ��.
		String sql = "select * from UserList where userAcc = ?";
		
		//--ͨ�����ӻ�ȡPreparedStatement����
		mStatement = mConnection.prepareStatement(sql);
		
		//--ͨ��PreparedStatement�����ռλ������ֵ����
		mStatement.setString(1, userAcc);
		
		//--ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		//executeQuery  �ǲ�ѯר��
		/*
		 * �����ĵ���������������.��������Ϊnull
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














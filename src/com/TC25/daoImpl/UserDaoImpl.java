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
		if (!rSet.next()) {
			return null;
		}
		User u = new User();				
		u.setUserId(rSet.getInt("USERID"));	
		u.setUserAcc(rSet.getString("USERACC"));
		u.setUserName(rSet.getString("USERNAME"));	
		u.setUserPwd(rSet.getString("USERPWD"));
		u.setUserPwdTip(rSet.getString("USERPWDTIP"));
		u.setUserStatus(rSet.getInt("USERSTATUS"));
			
		return u;
	}


	@Override
	public boolean isUserAccExist(String userAcc) throws SQLException {
		String sql = "select * from UserList where userAcc = ?";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, userAcc);
		rSet = mStatement.executeQuery();
		if (rSet.next()) {
			return true;
		}
		return false;
	}


	/* (�� Javadoc)  
	 * <p>Title: addUserToDataBase</p>  
	 * <p>Description: </p>  
	 * @param u
	 * @return
	 * @throws SQLException  
	 * @see com.TC25.dao.UserDao#addUserToDataBase(com.TC25.bean.User)  
	 */  
	@Override
	public boolean addUserToDataBase(User u) throws SQLException {
		String sql = "insert into UserList (userId,userAcc,userPwd,userName,userPwdTip)values(USERID_SEQ.nextval,?,?,?,?)";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, u.getUserAcc());
		mStatement.setString(2, u.getUserPwd());
		mStatement.setString(3, u.getUserName());
		mStatement.setString(4, u.getUserPwdTip());
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		return true;
	}

}














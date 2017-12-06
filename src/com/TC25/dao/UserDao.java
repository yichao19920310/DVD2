package com.TC25.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.User;

//--���ݿ����. ��ɾ�Ĳ������д�������.

public interface UserDao {

	/**
	 * �����û��˻���ȡUser����.(�����ݿ��в�ѯ������.)
	 * @param userAccount
	 * @return
	 * @throws SQLException 
	 */
	public User getUserByUserAcc(String userAcc) throws SQLException;

	public boolean isUserAccExist(String userAcc) throws SQLException;
	
	public boolean addUserToDataBase(User u) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: getAllDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param     ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public ArrayList<DVD> getDvdList(int i) throws SQLException;

	/**  
	 * @Title: lendDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param id
	 * @param @return    ����  
	 * @return boolean    ��������  
	 * @throws  
	 */  
	public boolean lendDvd(int id) throws SQLException;

	public ArrayList<DVD> getDvdByUser() throws SQLException;


}















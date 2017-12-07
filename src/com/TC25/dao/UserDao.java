package com.TC25.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.LendRecord;
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

	public ArrayList<LendRecord> getLrByUser() throws SQLException;

	/**  
	 * @Title: RetuDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param id    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public boolean RetuDvd(int id) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: addDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param dvdName    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public boolean addDvd(String dvdName) throws SQLException;

	/**  
	 * @Title: subDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param id    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public boolean subDvd(int id) throws SQLException;

	/**  
	 * @Title: changeUserStatus  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param i    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public boolean changeUserStatus(int i) throws SQLException;


}















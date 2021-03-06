package com.TC25.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.LendRecord;
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

	/**
	 * @throws SQLException   
	 * @Title: getAllDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param     参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public ArrayList<DVD> getDvdList(int i) throws SQLException;

	/**  
	 * @Title: lendDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param id
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */  
	public boolean lendDvd(int id) throws SQLException;

	public ArrayList<LendRecord> getLrByUser() throws SQLException;

	/**  
	 * @Title: RetuDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param id    参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public boolean RetuDvd(int id) throws SQLException;

	/**
	 * @throws SQLException   
	 * @Title: addDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param dvdName    参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public boolean addDvd(String dvdName) throws SQLException;

	/**  
	 * @Title: subDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param id    参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public boolean subDvd(int id) throws SQLException;

	/**  
	 * @Title: changeUserStatus  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param i    参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public boolean changeUserStatus(int i) throws SQLException;


}















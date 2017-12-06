package com.TC25.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.User;

public interface UserBiz {

	
	/**
	 * 根据账户和密码进行登录
	 * @param userAccount  用户账户
	 * @param userPwd      用户密码
	 * @return      登录成功返回true,否则返回false.
	 */
	public boolean userLogin(String userAcc,String userPwd) ;
	
	public boolean checkUserAcc(String userAcc);

	public boolean checkUserPwd(String userPwd);
	
	public boolean userRegist(String userAcc, String userPwd, String userName, String userPwdTip);

	public void getUserInfo();

	/**
	 * @return   
	 * @Title: showAllDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param     参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public ArrayList<DVD> showDvd(int i);

	/**
	 * @param id   
	 * @Title: lendDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param     参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public boolean lendDvd(int id);

	/**  
	 * @Title: checkDvdIdLendable  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param id
	 * @param @param dvdList    参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public boolean checkDvdIdLendable(int id, ArrayList<DVD> dvdList);

	public boolean checkReturnableDvd();

	public boolean RetuDvdById(int id);

	/**  
	 * @Title: addDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param dvdName    参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	public boolean addDvd(String dvdName);

	/**  
	 * @Title: subDvd  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param dvdId
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */  
	public boolean subDvd(int id);

}

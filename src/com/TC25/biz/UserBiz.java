package com.TC25.biz;

import java.sql.SQLException;

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
}

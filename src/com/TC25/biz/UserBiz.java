package com.TC25.biz;

import java.sql.SQLException;

public interface UserBiz {

	
	/**
	 * �����˻���������е�¼
	 * @param userAccount  �û��˻�
	 * @param userPwd      �û�����
	 * @return      ��¼�ɹ�����true,���򷵻�false.
	 */
	public boolean userLogin(String userAcc,String userPwd) ;
	
	public boolean checkUserAcc(String userAcc);

	public boolean checkUserPwd(String userPwd);
	
	public boolean userRegist(String userAcc, String userPwd, String userName, String userPwdTip);
}

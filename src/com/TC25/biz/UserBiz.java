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
	
	public boolean checkUserAcc(String userAcc) throws SQLException;

	public boolean checkUserPwd(String userPwd);
}

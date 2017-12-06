package com.TC25.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.User;

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

	public void getUserInfo();

	/**
	 * @return   
	 * @Title: showAllDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param     ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public ArrayList<DVD> showDvd(int i);

	/**
	 * @param id   
	 * @Title: lendDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param     ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public boolean lendDvd(int id);

	/**  
	 * @Title: checkDvdIdLendable  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param id
	 * @param @param dvdList    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public boolean checkDvdIdLendable(int id, ArrayList<DVD> dvdList);

	public boolean checkReturnableDvd();

	public boolean RetuDvdById(int id);

	/**  
	 * @Title: addDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param dvdName    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	public boolean addDvd(String dvdName);

	/**  
	 * @Title: subDvd  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param dvdId
	 * @param @return    ����  
	 * @return boolean    ��������  
	 * @throws  
	 */  
	public boolean subDvd(int id);

}

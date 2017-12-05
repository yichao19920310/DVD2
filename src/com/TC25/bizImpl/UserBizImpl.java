package com.TC25.bizImpl;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.TC25.bean.User;
import com.TC25.biz.UserBiz;
import com.TC25.dao.UserDao;
import com.TC25.daoImpl.UserDaoImpl;

public class UserBizImpl implements UserBiz {

	public static User mUser;
	UserDao ud = new UserDaoImpl();
	@Override
	public boolean userLogin(String userAcc, String userPwd) {
	
		if (userAcc == null || userPwd == null || userAcc.length() == 0 || userPwd.length() == 0) {
			return false;
		}
		
		
		try {
			mUser = ud.getUserByUserAcc(userAcc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mUser == null) {
			return false;
		}
		
		//--��ʼ��֤����
		if(userPwd.equals(mUser.getUserPwd())) {
			return true;
		}
		return false;
		
		
		
	}
	@Override
	public boolean checkUserAcc(String userAcc) {
		if (userAcc == null || userAcc.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_.]{5,15}");
		Matcher m = p.matcher(userAcc);
		try {
			if (m.matches() && !ud.isUserAccExist(userAcc)) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean userRegist(String userAcc, String userPwd, String userName, String userPwdTip) {
		User u = new User(userAcc,userName,userPwd,userPwdTip);
		boolean isSuccess = false;
		try {
			isSuccess = ud.addUserToDataBase(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	@Override
	public boolean checkUserPwd(String userPwd) {
		if (userPwd == null || userPwd.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile("[a-zA-Z0-9_.*]{6,16}");
		Matcher m = p.matcher(userPwd);
		if(m.matches()) {
			return true;
		}
		return false;
	}
	@Override
	public void getUserInfo() {
		try {
			mUser = ud.getUserByUserAcc(mUser.getUserAcc());
			System.out.println(mUser.toString());			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

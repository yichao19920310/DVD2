package com.TC25.bizImpl;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.TC25.bean.User;
import com.TC25.biz.UserBiz;
import com.TC25.dao.UserDao;
import com.TC25.daoImpl.UserDaoImpl;

public class UserBizImpl implements UserBiz {

	@Override
	public boolean userLogin(String userAcc, String userPwd) {
	
		if (userAcc == null || userPwd == null || userAcc.length() == 0 || userPwd.length() == 0) {
			return false;
		}
		
		UserDao ud = new UserDaoImpl();
		User u = null;
		try {
			u = ud.getUserByUserAcc(userAcc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u == null) {
			return false;
		}
		
		//--开始验证密码
		if(userPwd.equals(u.getUserPwd())) {
			return true;
		}
		return false;
		
		
		
	}
	@Override
	public boolean checkUserAcc(String userAcc) throws SQLException {
		if (userAcc == null || userAcc.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_.]{5,15}");
		Matcher m = p.matcher(userAcc);
		UserDao ud = new UserDaoImpl();
		if (m.matches() && !ud.isUserAccExist(userAcc)) {
			return true;
		}
		return false;
	}
	
	public boolean userRegist(String userAcc, String userPwd, String userName, String userPwdTip) {
		return false;
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

}

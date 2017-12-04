package com.TC25.view;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class LoginView extends View{

	
	@Override
	public View showView() {
		
		System.out.println("=====>>>用户登录");
		System.out.println("请输入用户账户:");
		String userAcc = iT.getString();
		System.out.println("请输入用户密码:");
		String userPwd = iT.getString();
		
		UserBiz ub = new UserBizImpl();
		if(ub.userLogin(userAcc, userPwd)) {
			//--登录成功
			System.out.println("登录成功!");
			mView = new UserMenuView();
		}else {
			//--登录失败
			System.out.println("登录失败!");
			mView = new MainView();
		}
		
		return mView;
	}

	
	
	
	
	
	
	
	
	
}

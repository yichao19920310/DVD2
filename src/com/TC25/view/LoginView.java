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
		
		
		if(ub.userLogin(userAcc, userPwd) && UserBizImpl.mUser.getUserStatus() != 3) {
			//--登录成功
			System.out.println("登录成功!");
			if(ub.checkUserStatus()) {
				mView = new UserMenuView();
			}else {
				System.out.println("您有逾期DVD未归还,已被列为黑户,请尽快归还!");
				mView = new RetuDvdView();
			}
			
		}else {
			//--登录失败
			System.out.println("登录失败!");
			mView = new MainView();
		}
		
		return mView;
	}

	
	
	
	
	
	
	
	
	
	
}

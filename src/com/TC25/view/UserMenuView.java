package com.TC25.view;

import com.TC25.bizImpl.UserBizImpl;

public class UserMenuView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>用户菜单");
		showMenu();		
		return mView;
	}
	
	
	public void showMenu() {
		System.out.println("1.查看用户信息");
		System.out.println("2.查看DVD");
		System.out.println("3.借出DVD");
		System.out.println("4.归还DVD");
		System.out.println("9.退出登录");
		System.out.println("0.退出系统");
		int choose = iT.getInt();
		switch(choose) {
		case 1: 
			mView = new ShowUserInfoView();
			break;
		case 2: 
			mView = new ShowDvdView();
			break;
		case 3: 
			mView = new LendDvdView();
			break;
		case 4:
			mView = new RetuDvdView();
			break;
		case 9: 
			UserBizImpl.mUser = null;
			mView = new MainView();
			break;
		case 0: 
			mView = null;
			break;
		default:
			mView = new UserMenuView();
			break;
		}
	}

}

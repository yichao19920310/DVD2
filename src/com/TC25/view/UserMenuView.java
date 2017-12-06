package com.TC25.view;

import com.TC25.bizImpl.UserBizImpl;

public class UserMenuView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>�û��˵�");
		showMenu();		
		return mView;
	}
	
	
	public void showMenu() {
		System.out.println("1.�鿴�û���Ϣ");
		System.out.println("2.�鿴DVD");
		System.out.println("3.���DVD");
		System.out.println("4.�黹DVD");
		System.out.println("9.�˳���¼");
		System.out.println("0.�˳�ϵͳ");
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

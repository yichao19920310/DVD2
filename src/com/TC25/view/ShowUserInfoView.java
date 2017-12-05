package com.TC25.view;

public class ShowUserInfoView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>用户信息");
		ub.getUserInfo();
		return mView = new UserMenuView();
	}

}

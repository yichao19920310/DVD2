package com.TC25.view;

public class ShowUserInfoView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>�û���Ϣ");
		ub.getUserInfo();
		return mView = new UserMenuView();
	}

}

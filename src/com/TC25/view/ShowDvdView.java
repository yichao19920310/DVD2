package com.TC25.view;

public class ShowDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>查看DVD");
		showMenu();
		int choose = iT.getInt();
		switch(choose) {
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
		return mView;
	}
	
	public void showMenu() {
		System.out.println("1.查看所有DVD");
		System.out.println("2.查看可借DVD");
		System.out.println("3.查看不可借DVD");
		System.out.println("0.返回");
	}

}

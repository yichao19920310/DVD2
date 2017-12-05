package com.TC25.view;

public class ShowDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>查看DVD");
		while(true) {
			showMenu();
			
			int choose = iT.getInt();
			
			switch(choose) {
			case 1:
				System.out.println("=====>>>查看所有DVD");
				ub.showDvd(1);
				break;
			case 2:
				System.out.println("=====>>>查看可借DVD");
				ub.showDvd(2);
				break;
			case 3:
				System.out.println("=====>>>查看不可借DVD");
				ub.showDvd(3);
				break;
			case 0:
				return mView = new UserMenuView();
			default:
				break;
				
			}
		}
		
		
	}
	
	public void showMenu() {
		System.out.println("1.查看所有DVD");
		System.out.println("2.查看可借DVD");
		System.out.println("3.查看不可借DVD");
		System.out.println("0.返回");
	}

}

package com.TC25.view;

public class ShowDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>�鿴DVD");
		while(true) {
			showMenu();
			
			int choose = iT.getInt();
			
			switch(choose) {
			case 1:
				System.out.println("=====>>>�鿴����DVD");
				ub.showDvd(1);
				break;
			case 2:
				System.out.println("=====>>>�鿴�ɽ�DVD");
				ub.showDvd(2);
				break;
			case 3:
				System.out.println("=====>>>�鿴���ɽ�DVD");
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
		System.out.println("1.�鿴����DVD");
		System.out.println("2.�鿴�ɽ�DVD");
		System.out.println("3.�鿴���ɽ�DVD");
		System.out.println("0.����");
	}

}

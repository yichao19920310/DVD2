package com.TC25.view;

public class ShowDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>�鿴DVD");
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
		System.out.println("1.�鿴����DVD");
		System.out.println("2.�鿴�ɽ�DVD");
		System.out.println("3.�鿴���ɽ�DVD");
		System.out.println("0.����");
	}

}

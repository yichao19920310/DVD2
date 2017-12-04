package com.TC25.view;

public class MainView extends View {

	@Override
	public View showView() {
		showWelcome();
		showMenu();
		return mView;
	}
	
	public void showWelcome() {
		for(int i = 0; i < 100; i++) {
			if(i == 49) {
				System.out.println();
				System.out.println("\t欢迎使用DVD管理器");
				System.out.println();
			}else {
				System.out.print("*");
			}			
		}
		System.out.println();
	}
	 
	public void showMenu() {
		System.out.println("=====>>>主界面");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("0.退出");
		int choose = iT.getInt();
		switch(choose) {
		case 1:
			mView = new LoginView();
			break;
		case 2:
			mView = new RegistView();
			break;
		case 0:
			mView = null;
			break;
		default:
			mView = new MainView();
			break;
		}		
	}	
}

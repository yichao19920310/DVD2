package com.TC25.view;

public class RetuDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>�黹DVD");
		
		if(ub.checkReturnableDvd()) {
			System.out.println("������Ҫ�黹��DVDID:");
			int id = iT.getInt();
			ub.RetuDvdById(id);
		}else{
			System.out.println("��û����Ҫ�黹��DVD!");			
		}
		return mView = new UserMenuView();
	}

}

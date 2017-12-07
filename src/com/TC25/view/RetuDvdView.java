package com.TC25.view;

public class RetuDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>归还DVD");
		
		if(ub.checkReturnableDvd()) {
			System.out.println("请输入要归还的DVDID:");
			int id = iT.getInt();
			if(ub.RetuDvdById(id)) {
				System.out.println("归还成功!");
				ub.checkUserStatus();
			}
		}else{
			System.out.println("您没有需要归还的DVD!");			
		}
		return mView = new UserMenuView();
	}

}

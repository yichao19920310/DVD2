package com.TC25.view;

import java.util.ArrayList;

import com.TC25.bean.DVD;

public class LendDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>借出DVD");
		if(ub.checkUserStatus()) {
			
		}else {
			System.out.println("您当前用户状态是黑户,仍有逾期DVD未归还,无法再借,请先归还DVD!");
			return mView = new UserMenuView();
		}
		
		System.out.println("以下是当前可借DVD列表:");
		ArrayList<DVD> dvdList = ub.showDvd(2);
		System.out.println("请输入要借出的DVDID:");
		int id = iT.getInt();
		if(ub.checkDvdIdLendable(id,dvdList)) {
			System.out.println("确认要借出此DVD嘛?(1:确认)");
			int isConfirm = iT.getInt();
			if(1 == isConfirm) {
				if(ub.lendDvd(id)) {
					System.out.println("借出成功!");
					
				}else {
					System.out.println("借出失败!");
				}
			}
			
		}else {
			System.out.println("DVDID不存在或不可借!");
		
		}
		
		return mView = new UserMenuView();
	}

}

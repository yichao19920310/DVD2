package com.TC25.view;

import java.util.ArrayList;

import com.TC25.bean.DVD;

public class LendDvdView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>���DVD");
		System.out.println("�����ǵ�ǰ�ɽ�DVD�б�:");
		ArrayList<DVD> dvdList = ub.showDvd(2);
		System.out.println("������Ҫ�����DVDID:");
		int id = iT.getInt();
		if(ub.checkDvdIdLendable(id,dvdList)) {
			System.out.println("ȷ��Ҫ���DVD��?(1:ȷ��)");
			int isConfirm = iT.getInt();
			if(1 == isConfirm) {
				if(ub.lendDvd(id)) {
					System.out.println("����ɹ�!");
					
				}else {
					System.out.println("���ʧ��!");
				}
			}
			
		}else {
			System.out.println("DVDID�����ڻ򲻿ɽ�!");
		
		}
		
		return mView = new UserMenuView();
	}

}

package com.TC25.view;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class LoginView extends View{

	
	@Override
	public View showView() {
		
		System.out.println("=====>>>�û���¼");
		System.out.println("�������û��˻�:");
		String userAcc = iT.getString();
		System.out.println("�������û�����:");
		String userPwd = iT.getString();
		
		
		if(ub.userLogin(userAcc, userPwd) && UserBizImpl.mUser.getUserStatus() != 3) {
			//--��¼�ɹ�
			System.out.println("��¼�ɹ�!");
			if(ub.checkUserStatus()) {
				mView = new UserMenuView();
			}else {
				System.out.println("��������DVDδ�黹,�ѱ���Ϊ�ڻ�,�뾡��黹!");
				mView = new RetuDvdView();
			}
			
		}else {
			//--��¼ʧ��
			System.out.println("��¼ʧ��!");
			mView = new MainView();
		}
		
		return mView;
	}

	
	
	
	
	
	
	
	
	
	
}

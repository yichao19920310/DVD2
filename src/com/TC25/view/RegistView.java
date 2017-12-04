package com.TC25.view;

import java.sql.SQLException;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class RegistView extends View {

	@Override
	public View showView() {
		System.out.println("=====>>>�û�ע��");
		UserBiz ub = new UserBizImpl();
		String userAcc = null;
		String userPwd = null;
		String userName = null;
		String userPwdTip = null;
		int step = 1;
		while(step == 0) {
			switch(step) {
			case 1:
				userAcc = SetUserAcc(ub);
				if(userAcc == null) {
					System.out.println("�˺Ÿ�ʽ����ȷ���˺��Ѵ���!");
					step = 1;
				}else {
					step = 2;
				}				
				break;
			case 2:
				userPwd = SetUserPwd(ub);
				if(userPwd == null) {
					System.out.println("�����ʽ����ȷ���������벻һ��!");
					step = 2;
				}else {
					step = 3;
				}
			}
		}
		
		
		
		return mView;
	}

	private String SetUserPwd(UserBiz ub) {
		System.out.println("�������û�����:");
		String userPwd = iT.getString();
		if(ub.checkUserPwd(userPwd)) {
			System.out.println("��ȷ���û�����:");
			String userPwd2 = iT.getString();
			if(userPwd2.equals(userPwd)) {
				return userPwd;
			}
		}
		return null;
	}

	private String SetUserAcc(UserBiz ub){
		
		try {
			System.out.println("�������û��˺�:");		
			String userAcc = iT.getString();
			if(ub.checkUserAcc(userAcc)) {
				return userAcc;
			} else {
				return null;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			return null;
		}
	}

}

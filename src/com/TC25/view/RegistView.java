package com.TC25.view;

import java.sql.SQLException;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class RegistView extends View {

	UserBiz ub = new UserBizImpl();
	@Override
	public View showView() {
		System.out.println("=====>>>�û�ע��");
		
		String userAcc = null;
		String userPwd = null;
		String userName = null;
		String userPwdTip = null;
		int step = 1;
		while(step != 0) {
			switch(step) {
			case 1:
				userAcc = SetUserAcc();
				if(userAcc == null) {
					System.out.println("�˺Ÿ�ʽ����ȷ���˺��Ѵ���!");
					step = 1;
				}else {
					step = 2;
				}				
				break;
			case 2:
				userPwd = SetUserPwd();
				if(userPwd == null) {
					System.out.println("�����ʽ����ȷ���������벻һ��!");
					step = 2;
				}else {
					step = isNeedName();
				}
				break;
			case 3:
				userName = SetUserName();
				if(userName == null) {
					System.out.println("�û��ǳƳ��Ȳ�����Ҫ��!");
					step = 3;
				}else {
					step = isNeedTip();
				}
				break;
			case 4:
				userPwdTip = SetUserPwdTip();
				if(userName == null) {
					System.out.println("������ʾ���Ȳ�����Ҫ��!");
					step = 4;
				}else {
					step = 0;
				}
				break;
			default:
				break;
			}
		}
		userName = autoSetName(userAcc, userName);
		userPwdTip = autoSetTip(userPwdTip);
		
		if(isConfirm(userAcc,userPwd,userName,userPwdTip)) {
			if(ub.userRegist(userAcc,userPwd,userName,userPwdTip)) {
				System.out.println("ע��ɹ�!���¼!");
				mView = new LoginView();
			}else {
				System.out.println("ע��ʧ��!");
				mView = new MainView();
			}
			
		}else {
			System.out.println("ע����ȡ��!");
			mView = new MainView();
		}
			
		
		return mView;
	}

	/**  
	 * @Title: isConfirm  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @return    ����  
	 * @return boolean    ��������  
	 * @throws  
	 */  
	private boolean isConfirm(String userAcc, String userPwd, String userName, String userPwdTip) {
		System.out.println("��ȷ������ע����Ϣ:");
		System.out.println("�û��˺�:"+ userAcc +"\t�û�����"+ userPwd);
		System.out.println("�û��ǳ�:"+ userName +"\t������ʾ"+ userPwdTip);
		System.out.println("1:ȷ�� 2:ȡ��");
		int choose = iT.getInt();
		if(choose == 1) {
			return true;
		}
		return false;
	}

	/**  
	 * @Title: autoSetTip  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param userPwdTip    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	private String autoSetTip(String userPwdTip) {
		if(userPwdTip == null) {
			userPwdTip = "";
		}
		return userPwdTip;
	}

	/**  
	 * @Title: autoSetName  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @param userAcc
	 * @param @param userName    ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	private String autoSetName(String userAcc, String userName) {
		if(userName == null) {
			userName = String.valueOf(userAcc);
		}
		return userName;
	}

	/**  
	 * @Title: SetUserPwdTip  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @return    ����  
	 * @return String    ��������  
	 * @throws  
	 */  
	private String SetUserPwdTip() {
		System.out.println("������������ʾ:");
		String userPwdTip = iT.getString();
		if(userPwdTip.length()<=16) {
			return userPwdTip;
		}
			
		return null;
	}

	/**  
	 * @Title: isNeedTip  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @return    ����  
	 * @return int    ��������  
	 * @throws  
	 */  
	private int isNeedTip() {
		System.out.println("�Ƿ�����������ʾ?(1:��)");
		int choose = iT.getInt();
		if (choose == 1) {
			return 4;
		}
		
		return 0;
	}

	/**  
	 * @Title: SetUserName  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param @return    ����  
	 * @return String    ��������  
	 * @throws  
	 */  
	private String SetUserName() {
		System.out.println("�������û��ǳ�:");
		String userName = iT.getString();
		if(userName.length()>=3 && userName.length()<=16) {
			return userName;
		}
			
		return null;
	}

	private String SetUserPwd() {
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

	private String SetUserAcc(){
		
		
			System.out.println("�������û��˺�:");		
			String userAcc = iT.getString();
			if(ub.checkUserAcc(userAcc)) {
				return userAcc;
			} else {
				return null;
			}
	}
	
	private int isNeedName() {
		System.out.println("�Ƿ������û��ǳ�?(1:��)");
		int choose = iT.getInt();
		if (choose == 1) {
			return 3;
		}
		
		return 4;
	}
}

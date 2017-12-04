package com.TC25.view;

import java.sql.SQLException;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class RegistView extends View {

	UserBiz ub = new UserBizImpl();
	@Override
	public View showView() {
		System.out.println("=====>>>用户注册");
		
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
					System.out.println("账号格式不正确或账号已存在!");
					step = 1;
				}else {
					step = 2;
				}				
				break;
			case 2:
				userPwd = SetUserPwd();
				if(userPwd == null) {
					System.out.println("密码格式不正确或两次输入不一致!");
					step = 2;
				}else {
					step = isNeedName();
				}
				break;
			case 3:
				userName = SetUserName();
				if(userName == null) {
					System.out.println("用户昵称长度不符合要求!");
					step = 3;
				}else {
					step = isNeedTip();
				}
				break;
			case 4:
				userPwdTip = SetUserPwdTip();
				if(userName == null) {
					System.out.println("密码提示长度不符合要求!");
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
				System.out.println("注册成功!请登录!");
				mView = new LoginView();
			}else {
				System.out.println("注册失败!");
				mView = new MainView();
			}
			
		}else {
			System.out.println("注册已取消!");
			mView = new MainView();
		}
			
		
		return mView;
	}

	/**  
	 * @Title: isConfirm  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws  
	 */  
	private boolean isConfirm(String userAcc, String userPwd, String userName, String userPwdTip) {
		System.out.println("请确认您的注册信息:");
		System.out.println("用户账号:"+ userAcc +"\t用户密码"+ userPwd);
		System.out.println("用户昵称:"+ userName +"\t密码提示"+ userPwdTip);
		System.out.println("1:确认 2:取消");
		int choose = iT.getInt();
		if(choose == 1) {
			return true;
		}
		return false;
	}

	/**  
	 * @Title: autoSetTip  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param userPwdTip    参数  
	 * @return void    返回类型  
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
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param userAcc
	 * @param @param userName    参数  
	 * @return void    返回类型  
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
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */  
	private String SetUserPwdTip() {
		System.out.println("请输入密码提示:");
		String userPwdTip = iT.getString();
		if(userPwdTip.length()<=16) {
			return userPwdTip;
		}
			
		return null;
	}

	/**  
	 * @Title: isNeedTip  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @return    参数  
	 * @return int    返回类型  
	 * @throws  
	 */  
	private int isNeedTip() {
		System.out.println("是否设置密码提示?(1:是)");
		int choose = iT.getInt();
		if (choose == 1) {
			return 4;
		}
		
		return 0;
	}

	/**  
	 * @Title: SetUserName  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @return    参数  
	 * @return String    返回类型  
	 * @throws  
	 */  
	private String SetUserName() {
		System.out.println("请输入用户昵称:");
		String userName = iT.getString();
		if(userName.length()>=3 && userName.length()<=16) {
			return userName;
		}
			
		return null;
	}

	private String SetUserPwd() {
		System.out.println("请输入用户密码:");
		String userPwd = iT.getString();
		if(ub.checkUserPwd(userPwd)) {
			System.out.println("请确认用户密码:");
			String userPwd2 = iT.getString();
			if(userPwd2.equals(userPwd)) {
				return userPwd;
			}
		}
		return null;
	}

	private String SetUserAcc(){
		
		
			System.out.println("请输入用户账号:");		
			String userAcc = iT.getString();
			if(ub.checkUserAcc(userAcc)) {
				return userAcc;
			} else {
				return null;
			}
	}
	
	private int isNeedName() {
		System.out.println("是否设置用户昵称?(1:是)");
		int choose = iT.getInt();
		if (choose == 1) {
			return 3;
		}
		
		return 4;
	}
}

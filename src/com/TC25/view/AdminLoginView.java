/**  
 * @Title: AdminLoginView.java  
 * @Package com.TC25.view  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author Administrator  
 * @date 2017年12月6日  
 * @version V1.0  
 */  
package com.TC25.view;

import javax.print.MultiDocPrintService;

import com.TC25.bizImpl.UserBizImpl;

/**  
 * @ClassName: AdminLoginView  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author Administrator  
 * @date 2017年12月6日  
 *    
 */
public class AdminLoginView extends View {

	/* (非 Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>>>管理员登录");
		System.out.println("请输入管理员账户:");
		String userAcc = iT.getString();
		System.out.println("请输入管理员密码:");
		String userPwd = iT.getString();
		
		
		if(ub.userLogin(userAcc, userPwd) && UserBizImpl.mUser.getUserStatus() == 0) {
			//--登录成功
			System.out.println("登录成功!");
			mView = new AdminMenuView();
		}else {
			//--登录失败
			System.out.println("登录失败!");
			mView = new MainView();
		}
		return mView;
	}

}

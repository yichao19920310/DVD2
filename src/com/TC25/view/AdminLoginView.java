/**  
 * @Title: AdminLoginView.java  
 * @Package com.TC25.view  
 * @Description: TODO(��һ�仰�������ļ���ʲô)  
 * @author Administrator  
 * @date 2017��12��6��  
 * @version V1.0  
 */  
package com.TC25.view;

import javax.print.MultiDocPrintService;

import com.TC25.bizImpl.UserBizImpl;

/**  
 * @ClassName: AdminLoginView  
 * @Description: TODO(������һ�仰��������������)  
 * @author Administrator  
 * @date 2017��12��6��  
 *    
 */
public class AdminLoginView extends View {

	/* (�� Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>>>����Ա��¼");
		System.out.println("���������Ա�˻�:");
		String userAcc = iT.getString();
		System.out.println("���������Ա����:");
		String userPwd = iT.getString();
		
		
		if(ub.userLogin(userAcc, userPwd) && UserBizImpl.mUser.getUserStatus() == 0) {
			//--��¼�ɹ�
			System.out.println("��¼�ɹ�!");
			mView = new AdminMenuView();
		}else {
			//--��¼ʧ��
			System.out.println("��¼ʧ��!");
			mView = new MainView();
		}
		return mView;
	}

}

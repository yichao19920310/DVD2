/**  
 * @Title: AdminMenuView.java  
 * @Package com.TC25.view  
 * @Description: TODO(��һ�仰�������ļ���ʲô)  
 * @author Administrator  
 * @date 2017��12��6��  
 * @version V1.0  
 */  
package com.TC25.view;

import com.TC25.bizImpl.UserBizImpl;

/**  
 * @ClassName: AdminMenuView  
 * @Description: TODO(������һ�仰��������������)  
 * @author Administrator  
 * @date 2017��12��6��  
 *    
 */
public class AdminMenuView extends View {

	/* (�� Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>>>����Ա�˵�");
		showMenu();
		int choose = iT.getInt();
		switch(choose) {
		case 1: 
			mView = new AddDvdView();
			break;
		case 2: 
			mView = new SubDvdView();
			break;
		case 3: 
			mView = new ShowDvdView();
			break;
		case 9: 
			UserBizImpl.mUser = null;
			mView = new MainView();
			break;
		case 0: 
			mView = null;
			break;
		default:
			mView = new AdminMenuView();
			break;
		}
		return mView;
	}

	/**  
	 * @Title: showMenu  
	 * @Description: TODO(������һ�仰�����������������)  
	 * @param     ����  
	 * @return void    ��������  
	 * @throws  
	 */  
	private void showMenu() {
		System.out.println("1.�ϼ�DVD");
		System.out.println("2.�¼�DVD");
		System.out.println("3.�鿴DVD");
		System.out.println("9.�˳�����Ա");
		System.out.println("0.�˳�ϵͳ");
		
	}

}

/**  
 * @Title: AdminMenuView.java  
 * @Package com.TC25.view  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author Administrator  
 * @date 2017年12月6日  
 * @version V1.0  
 */  
package com.TC25.view;

import com.TC25.bizImpl.UserBizImpl;

/**  
 * @ClassName: AdminMenuView  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author Administrator  
 * @date 2017年12月6日  
 *    
 */
public class AdminMenuView extends View {

	/* (非 Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>>>管理员菜单");
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
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param     参数  
	 * @return void    返回类型  
	 * @throws  
	 */  
	private void showMenu() {
		System.out.println("1.上架DVD");
		System.out.println("2.下架DVD");
		System.out.println("3.查看DVD");
		System.out.println("9.退出管理员");
		System.out.println("0.退出系统");
		
	}

}

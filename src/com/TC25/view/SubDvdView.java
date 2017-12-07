/**  
 * @Title: subDvd.java  
 * @Package com.TC25.view  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author Administrator  
 * @date 2017年12月6日  
 * @version V1.0  
 */  
package com.TC25.view;

import java.util.ArrayList;

import com.TC25.bean.DVD;

/**  
 * @ClassName: subDvd  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author Administrator  
 * @date 2017年12月6日  
 *    
 */
public class SubDvdView extends View {

	/* (非 Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>下架DVD");
		ArrayList<DVD> dvdList = ub.showDvd(2);
		System.out.println("请输入要下架的DVDID:");
		int id = iT.getInt();
		if(ub.checkDvdIdLendable(id,dvdList)) {
			System.out.println("确认要下架此DVD嘛?(1:确认)");
			int isConfirm = iT.getInt();
			if(1 == isConfirm) {
				if(ub.subDvd(id)) {
					System.out.println("下架成功!");
					
				}else {
					System.out.println("下架失败!");
				}
			}
			
		}else {
			System.out.println("DVDID不存在或已被借出无法下架!");
		
		}
	
		return mView = new AdminMenuView();

	}

}

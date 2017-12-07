/**  
 * @Title: addDvd.java  
 * @Package com.TC25.view  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author Administrator  
 * @date 2017年12月6日  
 * @version V1.0  
 */  
package com.TC25.view;

/**  
 * @ClassName: addDvd  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author Administrator  
 * @date 2017年12月6日  
 *    
 */
public class AddDvdView extends View {

	/* (非 Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>上架DVD");
		System.out.println("请输入要上架的DVD名称:");
		String dvdName = iT.getString();
		if(ub.addDvd(dvdName)) {
			System.out.println("操作成功!");
		}else {
			System.out.println("操作失败!");
		}
		return mView = new AdminMenuView();
	}

}

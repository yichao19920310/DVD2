/**  
 * @Title: addDvd.java  
 * @Package com.TC25.view  
 * @Description: TODO(��һ�仰�������ļ���ʲô)  
 * @author Administrator  
 * @date 2017��12��6��  
 * @version V1.0  
 */  
package com.TC25.view;

/**  
 * @ClassName: addDvd  
 * @Description: TODO(������һ�仰��������������)  
 * @author Administrator  
 * @date 2017��12��6��  
 *    
 */
public class AddDvdView extends View {

	/* (�� Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>�ϼ�DVD");
		System.out.println("������Ҫ�ϼܵ�DVD����:");
		String dvdName = iT.getString();
		if(ub.addDvd(dvdName)) {
			System.out.println("�����ɹ�!");
		}else {
			System.out.println("����ʧ��!");
		}
		return mView = new AdminMenuView();
	}

}

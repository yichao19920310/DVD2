/**  
 * @Title: subDvd.java  
 * @Package com.TC25.view  
 * @Description: TODO(��һ�仰�������ļ���ʲô)  
 * @author Administrator  
 * @date 2017��12��6��  
 * @version V1.0  
 */  
package com.TC25.view;

import java.util.ArrayList;

import com.TC25.bean.DVD;

/**  
 * @ClassName: subDvd  
 * @Description: TODO(������һ�仰��������������)  
 * @author Administrator  
 * @date 2017��12��6��  
 *    
 */
public class SubDvdView extends View {

	/* (�� Javadoc)  
	 * <p>Title: showView</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.view.View#showView()  
	 */
	@Override
	public View showView() {
		System.out.println("=====>�¼�DVD");
		ArrayList<DVD> dvdList = ub.showDvd(2);
		System.out.println("������Ҫ�¼ܵ�DVDID:");
		int id = iT.getInt();
		if(ub.checkDvdIdLendable(id,dvdList)) {
			System.out.println("ȷ��Ҫ�¼ܴ�DVD��?(1:ȷ��)");
			int isConfirm = iT.getInt();
			if(1 == isConfirm) {
				if(ub.subDvd(id)) {
					System.out.println("�¼ܳɹ�!");
					
				}else {
					System.out.println("�¼�ʧ��!");
				}
			}
			
		}else {
			System.out.println("DVDID�����ڻ��ѱ�����޷��¼�!");
		
		}
	
		return mView = new AdminMenuView();

	}

}

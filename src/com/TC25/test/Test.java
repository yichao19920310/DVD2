package com.TC25.test;

import com.TC25.tools.DBHelper;
import com.TC25.view.*;

public class Test {

	/* ҳ��(View) ���� ҵ��(Biz)
	 * 
	 * ҵ��(Biz)  ���� ���ݲ�����(Dao)
	 * 
	 * ���ݲ�����(Dao) ����ʵ���� Bean
	 *
	 */
	public static void main(String[] args) {
		View view  = new MainView();
		while(view != null) {
			view = view.showView();
		}
		System.out.println("��ӭ�ٴ�ʹ��!");
		
	}
}











package com.TC25.test;

import com.TC25.tools.DBHelper;
import com.TC25.view.*;

public class Test {

	/* 页面(View) 调用 业务(Biz)
	 * 
	 * 业务(Biz)  调用 数据操作类(Dao)
	 * 
	 * 数据操作类(Dao) 调用实体类 Bean
	 *
	 */
	public static void main(String[] args) {
		View view  = new MainView();
		while(view != null) {
			view = view.showView();
		}
		System.out.println("欢迎再次使用!");
		
	}
}











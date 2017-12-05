package com.TC25.view;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;
import com.TC25.tools.InputTool;

public abstract class View {

	UserBiz ub = new UserBizImpl();
	InputTool iT = InputTool.getInstance();
	View mView;
	public abstract View showView();
}

package com.TC25.view;

import com.TC25.tools.InputTool;

public abstract class View {

	InputTool iT = InputTool.getInstance();
	View mView;
	public abstract View showView();
}

package com.portfolio.model;

import com.portfolio.activities.CustomThemeWindow;
import com.portfolio.model.interfaces.IPage;

public abstract class  Page extends CustomThemeWindow implements IPage {

	protected int type;
	protected String name;
	protected String iconURL;
	protected int pos;
	
	@Override
	public int getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPosition() {
		return pos;
	}

	@Override
	public String getIconUrl() {
		return iconURL;
	}
}

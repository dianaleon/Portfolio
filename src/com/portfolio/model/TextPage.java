package com.portfolio.model;

import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.ITextPage;


public class TextPage extends Page implements ITextPage {

	private String text;
	
	public TextPage(String text) {
		this.type = IPage.type_text;
		this.text = text;
	}
	
	@Override
	public String getText() {
		return text;
	}

}

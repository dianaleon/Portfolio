package com.portfolio.model;

import com.portfolio.model.interfaces.IContactPage;
import com.portfolio.model.interfaces.IPage;


public class ContactPage extends Page implements IContactPage {

	private String text;
	
	public ContactPage(String text) {
		this.type = IPage.type_contact;
		this.text = text;
	}
	
	@Override
	public String getText() {
		return text;
	}

}

package com.portfolio.model.entities;

import java.util.List;

import com.portfolio.model.adapter.ContactItem;
import com.portfolio.model.interfaces.IContactPage;
import com.portfolio.model.interfaces.IPage;


public class ContactPage extends Page implements IContactPage {

	public List<ContactItem> items;
	
	public ContactPage(List<ContactItem> items) {
		this.type = IPage.type_contact;
		this.items = items;
	}

	@Override
	public List<ContactItem> getItems() {
		return items;
	}
	

}

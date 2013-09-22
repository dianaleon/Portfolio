package com.portfolio.model.interfaces;

import java.util.List;

import com.portfolio.model.adapter.ContactItem;

public interface IContactPage extends IPage {

	public List<ContactItem> getItems();

}

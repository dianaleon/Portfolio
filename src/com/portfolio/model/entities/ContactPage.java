package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.adapter.ContactItem;
import com.portfolio.model.interfaces.IContactPage;
import com.portfolio.model.interfaces.IPage;

public class ContactPage extends Page implements IContactPage {

	public List<ContactItem> items;

	public ContactPage(JSONObject jsonObject) {
		this.type = IPage.type_contact;
		this.items = new ArrayList<ContactItem>();
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				ContactItem contactItem = new ContactItem();
				contactItem.setType(object.getString("code"));
				contactItem.setValue(object.getString("value"));
				this.items.add(contactItem);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ContactItem> getItems() {
		return items;
	}

}

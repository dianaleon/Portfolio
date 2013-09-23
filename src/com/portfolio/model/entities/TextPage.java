package com.portfolio.model.entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.ITextPage;


public class TextPage extends Page implements ITextPage {

	private String text;
	
	public TextPage(JSONObject jsonObject) {
		this.type = IPage.type_text;
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
            	JSONObject object = data.getJSONObject(index);
            	this.text = object.getString("value");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getText() {
		return text;
	}

}

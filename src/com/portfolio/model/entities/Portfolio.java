package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IPage;

public class Portfolio {

	private List<IPage> pages;
	
	public Portfolio(final JSONObject JSONPortfolio) {
        try {
        	this.pages = new ArrayList<IPage>();
            JSONArray pages = JSONPortfolio.getJSONArray("page");
            for (int index = 0; index < pages.length(); index++) {
            	JSONObject page = pages.getJSONObject(index);
            	JSONObject type = page.getJSONObject("type");
            	if (type.getString("code").equalsIgnoreCase("text")) {
            		TextPage textPage = new TextPage(page);
            		this.pages.add(textPage);
            	}
            	if (type.getString("code").equalsIgnoreCase("photos-gallery")) {
            		PhotoGaleryPage photoGaleryPage = new PhotoGaleryPage(page);
            		this.pages.add(photoGaleryPage);
            	}
            	if (type.getString("code").equalsIgnoreCase("contact")) {
            		ContactPage contactPage = new ContactPage(page);
            		this.pages.add(contactPage);
            	}
            	if (type.getString("code").equalsIgnoreCase("network")) {
            		NetworkPage networkPage = new NetworkPage(page);
            		this.pages.add(networkPage);
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public int getNumberPages() {
		return pages.size();
	}

	public IPage getPage(int numberPage) {
		return pages.get(numberPage - 1);
	}
}

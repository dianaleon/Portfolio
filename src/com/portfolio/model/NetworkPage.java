package com.portfolio.model;

import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.IPage;


public class NetworkPage extends Page implements INetworkPage {

	private String text;
	
	public NetworkPage(String text) {
		this.type = IPage.type_network;
		this.text = text;
	}
	
	@Override
	public String getText() {
		return text;
	}

}

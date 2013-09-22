package com.portfolio.model.entities;

import java.util.List;

import com.portfolio.model.adapter.NetworkItem;
import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.IPage;


public class NetworkPage extends Page implements INetworkPage {

	private List<NetworkItem> items;
	
	public NetworkPage(List<NetworkItem> items) {
		this.type = IPage.type_network;
		this.items = items;
	}

	@Override
	public List<NetworkItem> getItems() {
		return items;
	}

}

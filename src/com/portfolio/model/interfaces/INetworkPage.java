package com.portfolio.model.interfaces;

import java.util.List;

import com.portfolio.model.adapter.NetworkItem;

public interface INetworkPage extends IPage {

	public List<NetworkItem> getItems();

}

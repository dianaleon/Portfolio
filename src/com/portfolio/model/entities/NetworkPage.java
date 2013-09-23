package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.adapter.NetworkItem;
import com.portfolio.model.interfaces.INetworkPage;
import com.portfolio.model.interfaces.IPage;

public class NetworkPage extends Page implements INetworkPage {

	private List<NetworkItem> items;

	public NetworkPage(JSONObject jsonObject) {
		this.type = IPage.type_network;
		this.items = new ArrayList<NetworkItem>();
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				NetworkItem networkItem = new NetworkItem();
				networkItem.setNetwork(object.getString("code"));
				networkItem.setUrl(object.getString("value"));
				this.items.add(networkItem);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<NetworkItem> getItems() {
		return items;
	}

}

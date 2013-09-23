package com.portfolio.model.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.IPhotoGaleryPage;

public class PhotoGaleryPage extends Page implements IPhotoGaleryPage {

	private List<String> imagesUrl;

	public PhotoGaleryPage(JSONObject jsonObject) {
		this.type = IPage.type_photo_galery;
		this.imagesUrl = new ArrayList<String>();
		try {
			JSONArray data = jsonObject.getJSONArray("data");
			for (int index = 0; index < data.length(); index++) {
				JSONObject object = data.getJSONObject(index);
				this.imagesUrl.add(object.getString("value"));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getImagesUrl() {
		return imagesUrl;
	}

}

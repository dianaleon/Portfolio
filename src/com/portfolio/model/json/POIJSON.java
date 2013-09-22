/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.model.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author aperez
 */
public class POIJSON extends IJSONParser {

	static POIJSON JSON = null; 
	
	public static POIJSON getInstance()	{
		if (JSON==null)
			JSON = new POIJSON();
		return JSON;
	}
	
	public Object deserialize(JSONObject object) throws JSONException {
//        POIVO poi = new POIVO();
//        poi.setCode(object.getLong("code"));
//        poi.setName(object.getString("name"));
//        poi.setAddress(object.getString("address"));
//        poi.setLatitud(object.getString("latitude"));
//        poi.setLongitud(object.getString("longitude"));
//        poi.setType(object.getString("type"));
//        poi.setImage(object.getString("image"));
//        poi.setDescription(object.getString("description"));
//        poi.setVersion(object.getLong("version"));
//        return poi;
		return null;
    }

    public JSONObject serialize(Object object) throws JSONException {
//    	POIVO poi = (POIVO) object;
        JSONObject js = new JSONObject();
//        js.put("code", poi.getCode());
//        js.put("name", poi.getName());
//        js.put("latitude", poi.getLatitude());
//        js.put("longitude", poi.getLongitude());
//        js.put("type", poi.getType());
//        js.put("version", poi.getVersion());
//        js.put("address", poi.getAddress());
        return js;
    }
}
/**
 * 
 */
package com.portfolio.model.json;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author aperez
 * 
 */
@SuppressWarnings("rawtypes")
public abstract class IJSONParser {

	public abstract Object deserialize(JSONObject object) throws JSONException;

	@SuppressWarnings("unchecked")
	public Vector deserializeVector(JSONArray array) throws JSONException {
		Vector vector = new Vector();
		for (int i = 0; i < array.length(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			Object object = deserialize(jsonObject);
			vector.addElement(object);
		}
		return vector;
	}

	public abstract JSONObject serialize(Object object) throws JSONException;

	public JSONArray serializeVector(Vector vector) throws JSONException {
		JSONArray array = new JSONArray();
		for (int i = 0; i < vector.size(); i++) {
			Object object = vector.elementAt(i);
			JSONObject jsonObject = serialize(object);
			array.put(jsonObject);
		}
		return array;
	}
}
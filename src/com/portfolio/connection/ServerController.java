package com.portfolio.connection;

import org.json.JSONObject;

import com.portfolio.utils.Config;

import android.content.Context;

public class ServerController {
 
	private static String TAG = ServerController.class.getSimpleName();
	
	protected Context context;
		
	public ServerController(Context context) {
		this.context = context;
	}
	
	protected synchronized JSONObject getResponse(String resourse, JSONObject param) throws Exception {
		try {
			String url = Config.getUrl() + resourse;
			return RestClient.connect(url);
		} catch (Exception e) {
			e.printStackTrace();
        	throw e;
		}
	}
	
}
package com.portfolio.utils;

public class Config {

	public static final String SERVER_URL = "108.161.132.152";
	public static final String IMAGES_PATH = "/STP/Images";
	//public static final String SERVER_URL = "192.168.1.6";
	public static final String IMAGES_EXTERNAL_PATH = "/STP/Images";
	public static final String IMAGES_INTERNAL_PATH = "/Images";

	public final static String getUrl() {
		return "http://" + SERVER_URL + ":8085/SRT/services/";
	}

	
}

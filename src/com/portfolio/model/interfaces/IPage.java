package com.portfolio.model.interfaces;

public interface IPage {

	public static final int type_text = 1;
	public static final int type_photo_galery = 2;
	public static final int type_contact = 3;
	public static final int type_network = 4;

	public int getType();
	
	public String getName();
	
	public int getPosition();
	
	public String getIconUrl();

}

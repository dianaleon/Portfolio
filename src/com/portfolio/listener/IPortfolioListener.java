package com.portfolio.listener;

import android.graphics.Bitmap;

public interface IPortfolioListener {

	public void onPortfolioReady();
	
	public void onImageReady(Bitmap bitmap);
}

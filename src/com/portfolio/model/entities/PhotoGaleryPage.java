package com.portfolio.model.entities;

import java.util.List;

import com.portfolio.model.interfaces.IPage;
import com.portfolio.model.interfaces.IPhotoGaleryPage;


public class PhotoGaleryPage extends Page implements IPhotoGaleryPage {

	private List<String> imagesUrl;
	
	public PhotoGaleryPage(List<String> imagesUrl) {
		this.type = IPage.type_photo_galery;
		this.imagesUrl = imagesUrl;
	}

	@Override
	public List<String> getImagesUrl() {
		return imagesUrl;
	}
	
	

}

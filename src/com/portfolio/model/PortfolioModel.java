package com.portfolio.model;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;

import com.portfolio.asyncTask.GetMediaAsyncTask;
import com.portfolio.asyncTask.GetPortfolioAsyncTask;
import com.portfolio.handler.AsyncTaskHandler;
import com.portfolio.listener.IPortfolioListener;
import com.portfolio.model.db.dao.MediaDAO;
import com.portfolio.model.entities.Media;
import com.portfolio.model.entities.Portfolio;
import com.portfolio.model.interfaces.IPage;

public class PortfolioModel {

	private static PortfolioModel instance = null;

	private Portfolio portfolio;
	private Context context;

	private PortfolioModel(Context context) {
		this.context = context;
	}

	public static PortfolioModel getInstance(Context context) {
		if (instance == null) {
			instance = new PortfolioModel(context);
		}
		return instance;
	}

	public void getPortfolio(final IPortfolioListener callback) {
		GetPortfolioAsyncTask task = new GetPortfolioAsyncTask(context,
				new AsyncTaskHandler(context) {

					@Override
					public void acceptRequest(Message msg) {
						Portfolio portfolio = (Portfolio) msg.obj;
						PortfolioModel.instance.portfolio = portfolio;
						callback.onPortfolioReady();
					}
				});
		task.exec();
	}

	public int getNumberPages() {
		return portfolio.getNumberPages();
	}

	public IPage getPageInfo(int numberPage) {
		return portfolio.getPage(numberPage);
	}

	public void getMedia(final IPortfolioListener callback, final String url) {
		int index = url.lastIndexOf("/");
		String name = url.substring(index+1);
		Media media = null;
		try {
			media = MediaDAO.getInstanced(context).getByUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (media != null) {
			String path = media.getPath();
			getImageFromFile(callback, path);
		} else {
			GetMediaAsyncTask task = new GetMediaAsyncTask(context,
					new AsyncTaskHandler(context) {

						@Override
						public void acceptRequest(Message msg) {
							String path = (String) msg.obj;
							saveMediaDBandGetImage(callback, url, path);
						}
					}, url, name);
			task.exec();
		}
	}
	
	private void saveMediaDBandGetImage(
			IPortfolioListener callback, String url, String path) {
		Media media = new Media();
		media.setPath(path);
		media.setUrl(url);
		MediaDAO mediaDAO = MediaDAO.getInstanced(context);
		try {
			mediaDAO.insertAndUpdate(media);
			getImageFromFile(callback, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getImageFromFile(IPortfolioListener callback, String path) {
		File imgFile = new  File(path);
		if(imgFile.exists()){
		    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
		    callback.onImageReady(myBitmap);
		}
	}
}
